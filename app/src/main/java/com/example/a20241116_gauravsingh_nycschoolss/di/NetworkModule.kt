package com.example.a20241116_gauravsingh_nycschoolss.di

import com.example.a20241116_gauravsingh_nycschoolss.retrofit.SchoolApi
import com.example.a20241116_gauravsingh_nycschoolss.utils.Constants
import com.example.a20241116_gauravsingh_nycschoolss.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{

        val okHttpBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpBuilder.addInterceptor(httpLoggingInterceptor)

        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun providesCountriesApi(retrofit : Retrofit): SchoolApi {
        return retrofit.create(SchoolApi::class.java)
    }

}