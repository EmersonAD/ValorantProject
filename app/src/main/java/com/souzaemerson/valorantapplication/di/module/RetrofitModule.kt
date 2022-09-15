package com.souzaemerson.valorantapplication.di.module

import com.google.gson.GsonBuilder
import com.souzaemerson.valorantapplication.data.remote.AuthService
import com.souzaemerson.valorantapplication.data.remote.ValorantService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun initRetrofit(): ValorantService {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl("https://valorant-api.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(ValorantService::class.java)
    }

    @Provides
    @Singleton
    fun initRetrofitLogin(): AuthService {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl("https://api.m3o.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
            .create(AuthService::class.java)
    }
}