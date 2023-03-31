package dev.ronnie.imageloaderdagger2.api.Api


import android.util.Log
import dev.ronnie.imageloaderdagger2.data.images.Movie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


interface RetrofitService {
  @GET("movielist.json")
  suspend fun getMovies(): Response<Movie>
}
