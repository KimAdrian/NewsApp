package com.kimadrian.newsapp.data.model

import com.squareup.moshi.Json

data class NewsResponse(
    @Json(name = "status")
    val status: String,
    @Json(name = "totalResults")
    val totalResults: Int,
    @Json(name = "articles")
    val articles: List<Article>
)
