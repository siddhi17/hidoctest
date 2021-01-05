package com.example.hidoctest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BooksResponse(

    @SerializedName("items")
    @Expose
    val items: List<Item>,

    @SerializedName("kind")
    @Expose
    val kind: String,

    @SerializedName("totalItems")
    @Expose
    val totalItems: Int
)