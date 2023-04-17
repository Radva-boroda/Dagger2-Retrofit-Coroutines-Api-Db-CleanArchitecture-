package dev.ronnie.imageloaderdagger2.dataa.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.ronnie.imageloaderdagger2.dataa.api.ApiService
import dev.ronnie.imageloaderdagger2.dataa.model.MovieItem
import dev.ronnie.imageloaderdagger2.utill.STARTING_PAGE
import java.io.IOException



class ImagesDataSource(private val apiService: ApiService) :
    PagingSource<Int, MovieItem>() {

                       // 2 //
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItem> {
        val page = params.key ?: STARTING_PAGE

        return try {
            val data = apiService.getMovies()
            LoadResult.Page(
                data = data,
                prevKey = if (page == STARTING_PAGE) null else page - 1,
                nextKey = if (data.isEmpty()) null else page + 1
            )
        } catch (throwable: Throwable) {
            var exception = throwable
            if (throwable is IOException) {
                exception = IOException("Please check internet connection")
            }
            LoadResult.Error(exception)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, MovieItem>): Int? {
        return state.anchorPosition
    }
}
