package dev.ronnie.imageloaderdagger2.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ronnie.imageloaderdagger2.api.repository.Repository
import dev.ronnie.imageloaderdagger2.data.images.Images
import kotlinx.coroutines.launch
import retrofit2.Response


@Suppress("deprecation", "BlockingMethodInNonBlockingContext")
class PicturesFragmentViewModel: ViewModel() {
  lateinit var repo: Repository
    val myImageList: MutableLiveData<Response<Images>> = MutableLiveData()
    fun getImageItem() {
        viewModelScope.launch {
            Log.i("PicFragViewMod","Coruntine19")
            myImageList.value = repo.getImagesPicture()
        }
    }
}