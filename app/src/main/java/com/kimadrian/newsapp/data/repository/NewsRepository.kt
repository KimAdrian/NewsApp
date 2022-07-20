package com.kimadrian.newsapp.data.repository

import com.kimadrian.newsapp.data.network.RetrofitInstance

class NewsRepository {
    suspend fun getNews() = RetrofitInstance.newsApiService.getNews(
        "bbc-news,cnn",
        "en",
        "a40eef3c200a4d13973c56d2d25ed534"
    )


}