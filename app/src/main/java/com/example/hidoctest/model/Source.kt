package com.example.hidoctest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Source(
    @Expose
    val id: String?,

    @SerializedName("name")
    @Expose
    val name: String
)