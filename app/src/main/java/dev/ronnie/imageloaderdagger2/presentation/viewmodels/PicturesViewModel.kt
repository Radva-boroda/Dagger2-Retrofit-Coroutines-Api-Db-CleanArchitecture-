package dev.ronnie.imageloaderdagger2.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dev.ronnie.imageloaderdagger2.dataa.repository.Repository
import dev.ronnie.imageloaderdagger2.dataa.model.Movie
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@Suppress("deprecation", "BlockingMethodInNonBlockingContext")
class PicturesViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    // 1 //       // 2 //
    //  private var currentResult: Flow<PagingData<MovieItem>>? = null
    val images = repository.getImages().cachedIn(viewModelScope)
}