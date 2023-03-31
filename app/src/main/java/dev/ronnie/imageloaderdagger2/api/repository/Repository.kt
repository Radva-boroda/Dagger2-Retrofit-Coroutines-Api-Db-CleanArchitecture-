package dev.ronnie.imageloaderdagger2.api.repository

import android.util.Log
import dev.ronnie.imageloaderdagger2.api.Api.RetrofitInstance
import dev.ronnie.imageloaderdagger2.data.images.Movie
import retrofit2.Response
import javax.inject.Inject


class Repository{
//@Inject constructor(private val retrofitService: Unit) {
   suspend fun getMovies(): Response<Movie> {Log.d("TAG", "movies_Repository")

       return RetrofitInstance.api.getMovies()
   }

//        val movies = retrofitService.getAllMovies()
//        Log.d("TAG", "movies ${movies}")
//        return movies
//    }

}