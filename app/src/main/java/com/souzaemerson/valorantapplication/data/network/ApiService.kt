package com.souzaemerson.valorantapplication.data.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private fun initRetrofit(): Retrofit {

        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl("https://valorant-api.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    val service: Service
        get() = initRetrofit().create(Service::class.java)
}