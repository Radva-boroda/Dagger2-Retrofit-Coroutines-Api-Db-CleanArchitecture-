package dev.ronnie.imageloaderdagger2.api.repository

import android.util.Log
import dev.ronnie.imageloaderdagger2.api.RetrofitService
import dev.ronnie.imageloaderdagger2.data.images.Movie
import retrofit2.Call
import javax.inject.Inject


class Repository @Inject constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies(): Call<List<Movie>> {

        val movies = retrofitService.getAllMovies()
        Log.d("TAG", "movies ${movies}")
        return movies
    }

}