package dev.ronnie.imageloaderdagger2.api

import dev.ronnie.imageloaderdagger2.data.images.Images
import retrofit2.Response
import retrofit2.http.GET


interface ApiServise {
  @GET("https://api.unsplash.com/")
  suspend fun getImages(): Response<Images>
}