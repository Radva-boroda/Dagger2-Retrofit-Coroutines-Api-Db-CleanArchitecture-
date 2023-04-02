package dev.ronnie.imageloaderdagger2.api.repository

import android.util.Log
import dev.ronnie.imageloaderdagger2.api.Api.RetrofitInstance
import dev.ronnie.imageloaderdagger2.data.model.Movie
import retrofit2.Response



class Repository {
    suspend fun getMovies(): Response<Movie> {
        Log.d("TAG", "movies_Repository")

        return RetrofitInstance.api.getMovies()
    }
}