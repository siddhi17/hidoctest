package com.example.hidoctest.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VolumeInfo(

    @SerializedName("publishedDate")
    @Expose
    val publishedDate: String,

    @SerializedName("publisher")
    @Expose
    val publisher: String,

    @SerializedName("description")
    @Expose
    val description: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("imageLinks")
    @Expose
    val imageLinks: ImageLinks,

    val allowAnonLogging: Boolean,
    val authors: List<String>,
    val averageRating: Double,
    val canonicalVolumeLink: String,
    val categories: List<String>,
    val contentVersion: String,
    val industryIdentifiers: List<IndustryIdentifier>,
    val infoLink: String,
    val language: String,
    val maturityRating: String,
    val pageCount: Int,
    val panelizationSummary: PanelizationSummary,
    val previewLink: String,
    val printType: String,
    val ratingsCount: Int,
    val readingModes: ReadingModes,
    val subtitle: String,

)