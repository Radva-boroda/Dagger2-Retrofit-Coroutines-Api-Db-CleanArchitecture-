package dev.ronnie.imageloaderdagger2.api


import android.util.Log
import dev.ronnie.imageloaderdagger2.data.images.Movie
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


interface RetrofitService {
  @GET("/photos")
  fun getAllMovies() : Call<List<Movie>>

  companion object {

    var retrofitService: RetrofitService? = null

    fun getInstance() : RetrofitService {

      if (retrofitService == null) {
        val client = OkHttpClient.Builder()
          .addNetworkInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
          .connectTimeout(60L, TimeUnit.SECONDS)
          .writeTimeout(60L, TimeUnit.SECONDS)
          .readTimeout(60L, TimeUnit.SECONDS)
          .build()
        val retrofit = Retrofit.Builder()
          .baseUrl("https://jsonplaceholder.typicode.com")
          .client(client)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
        retrofitService = retrofit.create(RetrofitService::class.java)
      }
      return retrofitService!!
      Log.i("Return","RetrofitService")
    }
  }
}
