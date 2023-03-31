package dev.ronnie.imageloaderdagger2.api.Api

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

        val client = OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .build()

    private val retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl("https://howtodoandroid.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

        val api: RetrofitService by lazy {
            Log.i("Return", "RetrofitService")
            retrofit.create(RetrofitService::class.java)
        }
    }
