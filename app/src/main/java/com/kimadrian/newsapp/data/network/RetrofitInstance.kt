package com.kimadrian.newsapp.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val Base_URL = "https://newsapi.org/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

object RetrofitInstance {
    val newsApiService: NewsApiService by lazy {
        Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(Base_URL)
            .build()
            .create(NewsApiService::class.java)

    }
}