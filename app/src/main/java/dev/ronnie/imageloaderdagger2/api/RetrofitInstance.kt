package dev.ronnie.imageloaderdagger2.api

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy { Log.i("retrofit","ConvectorJGSON")
        Retrofit.Builder().baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    }
    val api: ApiServise by lazy {Log.i("Communication","API_SERVICE")
        retrofit.create(ApiServise::class.java)
    }

}

