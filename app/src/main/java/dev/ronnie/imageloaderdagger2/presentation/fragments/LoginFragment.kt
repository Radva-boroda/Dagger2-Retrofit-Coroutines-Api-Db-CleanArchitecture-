package dev.ronnie.imageloaderdagger2.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import dagger.android.support.DaggerFragment
import dev.ronnie.imageloaderdagger2.R
import dev.ronnie.imageloaderdagger2.data.model.ImagesResponse
import dev.ronnie.imageloaderdagger2.databinding.ActivityMainBinding
// import dev.ronnie.imageloaderdagger2.presentation.adapters.ImagesAdapter
import dev.ronnie.imageloaderdagger2.presentation.adapters.LoadingStateAdapter
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.LoginFragmentViewModel
import dev.ronnie.imageloaderdagger2.utils.hideSoftKeyboard
import dev.ronnie.imageloaderdagger2.utils.toast
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject



class LoginFragment : DaggerFragment(R.layout.fragment_login)




//    private var job: Job? = null

//    private var hasInitiatedInitialCall = false
//        //    private lateinit var binding: LoginFragmentBinding

//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory
//
//    private val adapter =
//        ImagesAdapter { imagesResponse, imageView ->
//            navigate(
//                imagesResponse,
//                imageView
//            )
//        }
//
//    private val viewModel: LoginFragmentViewModel by viewModels {
//        viewModelFactory
//    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)

    //    binding = FragmentSearchBinding.bind(view)
 //       (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
//
//        setAdapter()
//        setSearchView()
 //       binding.searchView.requestFocus()

//        //prevents the method being called again onbackpressed pressed.
//        if (!hasInitiatedInitialCall) {
//   //         viewModel.currentQuery()?.let { searchImage(it); binding.searchView.setText(it) }
//            hasInitiatedInitialCall = true
//        }
//


//    @SuppressLint("ClickableViewAccessibility")
//    private fun setSearchView() {
//       binding.searchView.setOnTouchListener { v, _ ->
//           v.isFocusableInTouchMode = true
//           false
//        }
//        binding.searchView.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
//
//            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                searchImage(binding.searchView.text.toString().trim())
//                return@OnEditorActionListener true
//            }
//            false
//        })
//
//        binding.searchView.setOnTouchListener(OnTouchListener { _, event ->
//
//            val drawableRight = 2
//
//            if (event.action == MotionEvent.ACTION_UP) {
//                if (event.rawX >= binding.searchView.right - binding.searchView.compoundDrawables[drawableRight].bounds.width()
//                ) {
//                    requireContext().showKeyBoard(binding.searchView)
//                    return@OnTouchListener true
//                }
//            }
    //        false
  //      })





//    private fun searchImage(query: String) {
//
//        if (query.isEmpty()) return
//        requireActivity().hideSoftKeyboard()
//        job?.cancel()
//        job = lifecycleScope.launch {
//            viewModel.searchImage(query).collect {
//                adapter.submitData(it)
//            }
//
//        }
//    }
//
//
//    private fun setAdapter() {
//  //      binding.imagesList.adapter = adapter.withLoadStateFooter(
//            LoadingStateAdapter { adapter.retry() }
//  //      )
//        adapter.addLoadStateListener {
//
//    //        binding.progress.isVisible = it.refresh is LoadState.Loading
//
//            if (it.refresh is LoadState.Error) {
//                requireContext().toast("There was a problem fetching data")
//            }
//        }
//    }
//
//    private fun navigate(imagesResponse: ImagesResponse, imageView: ImageView) {
//      //  val action = SearchFragmentDirections.toSingleImageFragment(imagesResponse)
//    //    binding.root.findNavController()
//     //       .navigate(action)
//    }
//
//
//}