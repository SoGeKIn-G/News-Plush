package com.gauravbora.newsplush.models

import com.gauravbora.newsplush.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)