package dev.ronnie.imageloaderdagger2.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.ronnie.imageloaderdagger2.api.repository.Repository
import dev.ronnie.imageloaderdagger2.data.model.Movie
import kotlinx.coroutines.launch
import retrofit2.Response


class PicturesViewModel : ViewModel() {
//@Inject constructor(private val repository: Repository)  : ViewModel() {

    val movieList: MutableLiveData<Response<Movie>> = MutableLiveData()
    val errorMessage = MutableLiveData<String>()
    val repository = Repository()
    fun getAllMovies() {

        viewModelScope.launch {
            movieList.value = repository.getMovies()
        }



        fun onFailure(call: Response<List<Movie>>, t: Throwable) {
            errorMessage.postValue(t.message)
        }
    }
}
