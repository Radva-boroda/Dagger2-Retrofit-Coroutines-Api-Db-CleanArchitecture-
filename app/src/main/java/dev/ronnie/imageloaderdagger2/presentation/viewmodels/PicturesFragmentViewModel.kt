package dev.ronnie.imageloaderdagger2.presentation.viewmodels

import android.app.Application
import android.content.ContentResolver
import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaScannerConnection
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dev.ronnie.imageloaderdagger2.data.model.ImagesResponse
import dev.ronnie.imageloaderdagger2.data.repository.Repository
import dev.ronnie.imageloaderdagger2.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject


/**
 *created by Ronnie Otieno on 03-Apr-21.
 **/

@Suppress("deprecation", "BlockingMethodInNonBlockingContext")
class PicturesFragmentViewModel @Inject constructor(
    private val app: Application,
    private val repo: Repository
) :
    AndroidViewModel(app) {
    var view1: String? = null
    val shouldRound = false

    private val _notifyDownloading = MutableLiveData<Int>()
    val notifyDownloading: LiveData<Int> get() = _notifyDownloading

    fun saveImage(
        bitmap: Bitmap, photoId: String
    ) = viewModelScope.launch(Dispatchers.Default) {
        try {
            val fos: OutputStream?
            var imageFile: File? = null
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val resolver: ContentResolver = app.applicationContext.contentResolver
                val contentValues = ContentValues()
                contentValues.put(
                    MediaStore.MediaColumns.DISPLAY_NAME,
                    "Image${System.currentTimeMillis()}"

                )
                contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/png")
                contentValues.put(
                    MediaStore.MediaColumns.RELATIVE_PATH,
                    Environment.DIRECTORY_DCIM + File.separator.toString() + "UnsplashImages"
                )
                val imageUri =
                    resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
                fos = imageUri?.let { resolver.openOutputStream(it) }
            } else {
                val myDir = File(
                    Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DCIM
                    ).toString() + File.separator.toString() + "UnsplashImages"
                )
                myDir.mkdirs()

                imageFile = File(myDir, "Image${System.currentTimeMillis()}.png")
                if (imageFile.exists()) imageFile.delete()
                imageFile.createNewFile()
                if (!imageFile.exists()) {
                    imageFile.mkdirs()
                }

                MediaScannerConnection.scanFile(
                    app.applicationContext,
                    arrayOf(imageFile.toString()),
                    null,
                    null
                )
                fos = FileOutputStream(imageFile)
            }
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
            fos?.flush()
            fos?.close()

            withContext(Dispatchers.Main) {
                _notifyDownloading.value = HAS_SAVED
                app.applicationContext.toast("Image saved successfully")
                try {
                    repo.sendDownload(photoId)
                } catch (_: Exception) {

                }
            }
        } catch (e: Exception) {

            Log.d("SavingImage", e.toString())
            withContext(Dispatchers.Main) {
                _notifyDownloading.value = ERROR_DOWNLOADING
                app.applicationContext.toast("There was a problem saving the image")
            }
        }

    }

    private var currentResult: Flow<PagingData<ImagesResponse>>? = null
    fun getImages(): Flow<PagingData<ImagesResponse>> {
        val orderBy = listOf("latest", "oldest", "popular").random()
        val newResult: Flow<PagingData<ImagesResponse>> =
            repo.getImages(orderBy).cachedIn(viewModelScope)
        currentResult = newResult
        return newResult
    }


    suspend fun getBitmapFromURL(src: String, photoId: String) {
        withContext(Dispatchers.Main) {
            _notifyDownloading.value = STARTING_DOWNLOAD
        }
        try {
            val url = URL(src)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input: InputStream = connection.inputStream
            val bitmap = BitmapFactory.decodeStream(input)

            saveImage(bitmap, photoId).also {
                withContext(Dispatchers.Main) {
                    _notifyDownloading.value = HAS_DOWNLOADED
                }
            }
        } catch (e: IOException) {
            withContext(Dispatchers.Main) {
                _notifyDownloading.value = ERROR_DOWNLOADING
                app.applicationContext.toast("There was a problem downloading the image")
            }

        }
    }

}