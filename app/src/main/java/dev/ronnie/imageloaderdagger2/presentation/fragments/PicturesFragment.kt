package dev.ronnie.imageloaderdagger2.presentation.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerFragment
import dev.ronnie.imageloaderdagger2.R
import dev.ronnie.imageloaderdagger2.databinding.FragmentPicturesBinding
import dev.ronnie.imageloaderdagger2.presentation.adapters.StartAdapter
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.PicturesFragmentViewModel



class PicturesFragment : DaggerFragment(R.layout.fragment_pictures) {
    private var _binding: FragmentPicturesBinding? = null
    private val binding get() = _binding!!
    val adapter = StartAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPicturesBinding.inflate(inflater, container, false)
      val viewModel = ViewModelProvider(this).get(PicturesFragmentViewModel::class.java)

        Log.i("image", "transfer")

        binding.recyclerV.adapter = adapter
        binding.recyclerV.layoutManager = GridLayoutManager(requireContext(), 3, LinearLayoutManager.VERTICAL, false)


        viewModel.getAllMovies()

        Log.i("adapter", "Norm")
        viewModel.movieList.observe(viewLifecycleOwner,{list -> list.body()?.let{adapter.setMovie(it)}
        })
//            .observe(viewLifecycleOwner, Observer {
//            Log.d("TAG", "onCreate")
//            adapter.setMovie(it)
//        })

//        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
//
//        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




