package dev.ronnie.imageloaderdagger2.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import dagger.android.support.DaggerFragment
import dev.ronnie.imageloaderdagger2.R
import dev.ronnie.imageloaderdagger2.data.model.ImagesResponse
import dev.ronnie.imageloaderdagger2.databinding.FragmentPicturesBinding
import dev.ronnie.imageloaderdagger2.presentation.adapters.ImagesAdapter
import dev.ronnie.imageloaderdagger2.presentation.adapters.LoadingStateAdapter
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.PicturesFragmentViewModel
import dev.ronnie.imageloaderdagger2.utils.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject



class PicturesFragment : DaggerFragment(R.layout.fragment_pictures) {

    private var hasInitiatedInitialCall = false
    private var job: Job? = null
    private lateinit var binding: FragmentPicturesBinding
    private val adapter =
        ImagesAdapter { imagesResponse, imageView -> navigate(imagesResponse, imageView) }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PicturesFragmentViewModel by viewModels {
        viewModelFactory
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPicturesBinding.bind(view)

        setAdapter()

        //prevents the method being called again onbackpressed pressed.
        if (!hasInitiatedInitialCall) {
            getImages()
            hasInitiatedInitialCall = true
        }
    }
    private fun getImages() {
        job?.cancel()
        job = lifecycleScope.launch {
            viewModel.getImages()
        }
    }

    private fun setAdapter() {
        binding.imagesList.adapter = adapter.withLoadStateFooter(
            LoadingStateAdapter { adapter.retry() }
        )
        adapter.addLoadStateListener {

            binding.progress.isVisible = it.refresh is LoadState.Loading

            if (it.refresh is LoadState.Error) {
                requireContext().toast("There was a problem fetching data")
            }
        }
    }
    private fun navigate(imagesResponse: ImagesResponse, imageView: ImageView) {
        // val extras = FragmentNavigatorExtras(imageView to imagesResponse.urls.regular) not working

    }
}
