package dev.ronnie.imageloaderdagger2.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import dagger.android.support.DaggerFragment
import dev.ronnie.imageloaderdagger2.R
import dev.ronnie.imageloaderdagger2.data.model.ImagesResponse
// import dev.ronnie.imageloaderdagger2.presentation.adapters.ImagesAdapter
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.WelcomeFragmentViewModel
import dev.ronnie.imageloaderdagger2.utils.toast
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 *created by Ronnie Otieno on 03-Apr-21.
 **/
class WelcomeFragment : DaggerFragment(R.layout.fragment_welcome) {

    var loginbottom: Button? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginbottom = view.findViewById<Button>(R.id.btn_login) as Button
        loginbottom!!.setOnClickListener { findNavController().navigate(R.id.fragment_login)
            Log.d("Button1", "CLicked..")
        }
    }
}
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//       // binding = FragmentImagesListBinding.bind(view)
//       // (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
//        setHasOptionsMenu(true)
//
//        setAdapter()
//
//        //prevents the method being called again onbackpressed pressed.
//        if (!hasInitiatedInitialCall) {
//            getImages()
//            hasInitiatedInitialCall = true
//        }
//
//    }

//    private fun getImages() {
//        job?.cancel()
//        job = lifecycleScope.launch {
//            viewModel.getImages().collect {
//                adapter.submitData(it)
//            }
//
//        }
//    }

//    private fun setAdapter() {
//    //    binding.imagesList.adapter = adapter.withLoadStateFooter(
//     //       LoadingStateAdapter { adapter.retry() }
//     //   )
//        adapter.addLoadStateListener {
//
//      //      binding.progress.isVisible = it.refresh is LoadState.Loading
//
//            if (it.refresh is LoadState.Error) {
//                requireContext().toast("There was a problem fetching data")
//            }
//        }
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        when (item.itemId) {
//            R.id.btn_login -> navigateSearch()
//            R.id.scroll_down -> scrollDown()
//            R.id.scroll_up -> scrollUp()
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.main_menu, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//    }
//
//    private fun navigateSearch() {
// //       binding.root.findNavController().navigate(WelcomFragmentDirections.toSearchFragment())
//    }
//
//    private fun scrollUp() {
//  //      binding.imagesList.scrollToPosition(0)
//    }
//
//    private fun scrollDown() {
//  //      binding.imagesList.scrollToPosition(adapter.itemCount - 1)
//    }
//
//
//    private fun navigate(imagesResponse: ImagesResponse, imageView: ImageView) {
//        // val extras = FragmentNavigatorExtras(imageView to imagesResponse.urls.regular) not working
//
//  //      val action = WelcomFragmentDirections.toSingleImageFragment(imagesResponse)
//  //      binding.root.findNavController()
//    //        .navigate(action)
//    }
//
//}