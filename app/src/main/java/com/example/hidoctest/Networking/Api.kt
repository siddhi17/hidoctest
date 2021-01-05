package com.example.hidoctest.Networking


import com.example.hidoctest.model.BooksResponse
import com.example.hidoctest.model.NewsResponse
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface Api {
    @GET("everything?q=bitcoin")
    fun getNewsList(
        @Query("sources") newsSource: String?,
        @Query("apiKey") apiKey: String?
    ): Call<NewsResponse?>?

    @GET("volumes?q=harry+potter")
    fun getBooksList(
    ): Call<BooksResponse?>?
}