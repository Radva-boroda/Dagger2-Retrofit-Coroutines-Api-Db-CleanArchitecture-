package dev.ronnie.imageloaderdagger2.dataa.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dev.ronnie.imageloaderdagger2.dataa.api.ApiService
import dev.ronnie.imageloaderdagger2.dataa.dataSource.ImagesDataSource
import dev.ronnie.imageloaderdagger2.utill.LOAD_SIZE
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {
    // 1 //
    fun getImages() = Pager(
        // 2 //
        config = PagingConfig(enablePlaceholders = false, pageSize = LOAD_SIZE),
        pagingSourceFactory = {
            Log.d("TAG", "movies_Repository")
            ImagesDataSource(apiService)
        }
    ).flow
}