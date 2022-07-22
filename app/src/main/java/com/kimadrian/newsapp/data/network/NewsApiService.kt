package com.kimadrian.newsapp.data.network

import com.kimadrian.newsapp.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("everything")
    suspend fun getNews(@Query("sources") sources: String,
                           @Query("language") language: String,
                           @Query("apiKey") apiKey: String): Response<NewsResponse>
}