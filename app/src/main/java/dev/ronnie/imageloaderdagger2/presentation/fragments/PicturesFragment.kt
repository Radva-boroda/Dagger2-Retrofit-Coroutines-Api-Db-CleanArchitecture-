package dev.ronnie.imageloaderdagger2.presentation.fragments


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import dev.ronnie.imageloaderdagger2.R
import dev.ronnie.imageloaderdagger2.presentation.adapters.StartAdapter
import dev.ronnie.imageloaderdagger2.presentation.viewmodels.PicturesFragmentViewModel


class PicturesFragment : DaggerFragment(R.layout.fragment_pictures) {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: StartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("PicturesFragment","Undergoing_Initialization_viewModel")

        val viewModel = ViewModelProvider(this).get(PicturesFragmentViewModel::class.java)// Ініціалізація ВЮ МОДЕЛі

        val v = inflater.inflate(R.layout.fragment_pictures, container, false)
        recyclerView = v?.findViewById<RecyclerView>(R.id.imagesss) as RecyclerView // айдішка
        adapter = StartAdapter()   // адаптер
        recyclerView.adapter = adapter // Устанавлюєм адаптер в рісакл вю
        viewModel.getImageItem() // метод спрацював але там нічого немає// Треба список покласти в переміну

        // Отут вилітає бо там проблеми з REPOSITORY
        viewModel.myImageList.observe(viewLifecycleOwner,{list->
            list.body()?.let{adapter.setList(it)}  //let полезен при работе с объектами, которые могут принимать значение null.
        })
        return v
    }
}


