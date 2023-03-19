package dev.ronnie.imageloaderdagger2.presentation.fragments

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import dev.ronnie.imageloaderdagger2.R
import dev.ronnie.imageloaderdagger2.data.model.ImagesResponse
import dev.ronnie.imageloaderdagger2.databinding.FragmentPicturesBinding
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.PicturesFragmentViewModel
import dev.ronnie.imageloaderdagger2.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class PicturesFragment : DaggerFragment(R.layout.fragment_pictures) {


    private var snackBar: Snackbar? = null
    private var image: ImagesResponse? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PicturesFragmentViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.download_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun startDownload() {
        makeSnackBar()
        viewModel.notifyDownloading.observe(viewLifecycleOwner, {
            when (it) {
                STARTING_DOWNLOAD -> {
                    snackBar?.show()
                }
                ERROR_DOWNLOADING -> {
                    snackBar?.dismiss()
                }
                HAS_DOWNLOADED -> {
                    snackBar?.setText("Saving...")
                }
                HAS_SAVED -> {
                    snackBar?.dismiss()
                }
            }
        })
        lifecycleScope.launch(Dispatchers.Default) {
            image?.let { viewModel.getBitmapFromURL(it.urls.full, it.id) }
        }
    }

    private fun makeSnackBar() {
        val parentLayout = requireActivity().findViewById<View>(android.R.id.content)
        snackBar = Snackbar.make(parentLayout, "Downloading...", Snackbar.LENGTH_INDEFINITE)

    }

    fun downLoadFull() {
        requireContext().toast("Downloading full resolution may take a while")
        startDownload()

    }

    override fun onDestroy() {
        super.onDestroy()
        snackBar?.dismiss()
    }

}
