package dev.ronnie.imageloaderdagger2.api.repository

import dev.ronnie.imageloaderdagger2.api.RetrofitInstance
import dev.ronnie.imageloaderdagger2.data.images.Images
import retrofit2.Response


class Repository {
    suspend fun getImagesPicture(): Response<Images>{
        return RetrofitInstance.api.getImages()
    }
}