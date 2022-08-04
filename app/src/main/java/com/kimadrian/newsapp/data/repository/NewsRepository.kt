package com.kimadrian.newsapp.data.repository

import com.kimadrian.newsapp.BuildConfig
import com.kimadrian.newsapp.data.network.RetrofitInstance

class NewsRepository {
    suspend fun getNews() = RetrofitInstance.newsApiService.getNews(
        sources = "bbc-news,cnn",
        language = "en",
        apiKey = BuildConfig.API_KEY
    )


}