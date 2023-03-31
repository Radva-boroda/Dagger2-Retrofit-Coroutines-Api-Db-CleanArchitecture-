package dev.ronnie.imageloaderdagger2.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ronnie.imageloaderdagger2.api.repository.Repository
import dev.ronnie.imageloaderdagger2.data.images.Movie
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class PicturesFragmentViewModel : ViewModel(){
//@Inject constructor(private val repository: Repository)  : ViewModel() {

    val movieList: MutableLiveData<Response<Movie>> = MutableLiveData()
    val errorMessage = MutableLiveData<String>()
    val repository = Repository()
    fun getAllMovies() {

        viewModelScope.launch {  // тут вилітає чогось
            movieList.value = repository.getMovies()
        }

//        val response = repository.getAllMovies()
//        response.enqueue(object : Callback<List<Movie>> {
//            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
//                movieList.postValue(response.body())
    }


            fun onFailure(call: Response<List<Movie>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        }


