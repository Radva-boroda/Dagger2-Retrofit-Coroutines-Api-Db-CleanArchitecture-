package dev.ronnie.imageloaderdagger2.presentation.fragments


import android.icu.lang.UCharacter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import dev.ronnie.imageloaderdagger2.R
import dev.ronnie.imageloaderdagger2.api.RetrofitService
import dev.ronnie.imageloaderdagger2.api.repository.Repository
import dev.ronnie.imageloaderdagger2.databinding.FragmentPicturesBinding
import dev.ronnie.imageloaderdagger2.presentation.adapters.StartAdapter
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.PicturesFragmentViewModel
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.ViewModelFactoryP


class PicturesFragment : DaggerFragment(R.layout.fragment_pictures) {
    private var _binding: FragmentPicturesBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: PicturesFragmentViewModel
             var recyclerView: RecyclerView? = null
     private val retrofitService = RetrofitService.getInstance()
             var  gridLayoutManager: GridLayoutManager? = null

    val adapter = StartAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPicturesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, ViewModelFactoryP(Repository(retrofitService))).get(
            PicturesFragmentViewModel::class.java
        )

        Log.i("image", "transfer")

        gridLayoutManager = GridLayoutManager(requireContext(), 3, LinearLayoutManager.VERTICAL, false)
        recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerV).also {
            it?.layoutManager = gridLayoutManager
        }

        binding.recyclerV.adapter = adapter
        binding.recyclerV.layoutManager = gridLayoutManager



        viewModel.movieList.observe(viewLifecycleOwner, Observer {
            Log.d("TAG", "onCreate: $it")
            adapter.setMovieList(it)
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {

        })
        viewModel.getAllMovies()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




