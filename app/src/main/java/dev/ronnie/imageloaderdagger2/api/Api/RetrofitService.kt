package dev.ronnie.imageloaderdagger2.api.Api



import dev.ronnie.imageloaderdagger2.data.model.Movie
import retrofit2.Response
import retrofit2.http.GET



interface RetrofitService {
  @GET("movielist.json")
  suspend fun getMovies(): Response<Movie>
}
