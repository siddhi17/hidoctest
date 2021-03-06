package com.example.hidoctest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageLinks(

    @SerializedName("smallThumbnail")
    @Expose
    val smallThumbnail: String,

    @SerializedName("thumbnail")
    @Expose
    val thumbnail: String
)