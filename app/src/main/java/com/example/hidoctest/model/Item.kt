package com.example.hidoctest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Item(

    val accessInfo: AccessInfo,
    val etag: String,
    val id: String,
    val kind: String,
    val saleInfo: SaleInfo,
    val searchInfo: SearchInfo,
    val selfLink: String,

    @SerializedName("volumeInfo")
    @Expose
    val volumeInfo: VolumeInfo
)