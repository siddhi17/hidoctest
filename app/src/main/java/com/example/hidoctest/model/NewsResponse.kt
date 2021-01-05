package com.example.hidoctest.model

import com.example.hidoctest.model.NewsArticle
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsResponse(

    @SerializedName("articles")
    @Expose
    val newsArticles: List<NewsArticle>,

    @SerializedName("status")
    @Expose
    val status: String,

    @SerializedName("totalResults")
    @Expose
    val totalResults: Int
)