package dev.ronnie.imageloaderdagger2.presentation.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import dev.ronnie.imageloaderdagger2.R
import dev.ronnie.imageloaderdagger2.databinding.FragmentPicturesBinding
import dev.ronnie.imageloaderdagger2.presentation.adapters.ImagesAdapter
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.PicturesViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


class FragmentPictures : DaggerFragment(R.layout.fragment_pictures) {
    private var binding: FragmentPicturesBinding? = null
    private val adapter = ImagesAdapter()
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: PicturesViewModel by viewModels {  Log.i("Inject", "viewModel")
        viewModelFactory
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPicturesBinding.inflate(inflater, container, false)

        viewLifecycleOwner.lifecycleScope.launch{
            viewModel.images.collectLatest{ adapter.submitData(it)}
        }
        Log.i("image", "transfer")
        binding?.recyclerV?.adapter = adapter
        binding?.recyclerV?.layoutManager =
            GridLayoutManager(requireContext(),3, LinearLayoutManager.VERTICAL, false)
        return binding!!.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}





