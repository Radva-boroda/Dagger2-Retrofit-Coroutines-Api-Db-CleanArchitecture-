package dev.ronnie.imageloaderdagger2.dataa.api



import dev.ronnie.imageloaderdagger2.dataa.model.MovieItem
import retrofit2.http.GET

interface ApiService {
  @GET("movielist.json")
  suspend fun getMovies(): List<MovieItem>
}
