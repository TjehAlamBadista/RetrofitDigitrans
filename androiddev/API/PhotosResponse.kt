package com.example.androiddev.API

import com.google.gson.annotations.SerializedName

class   PhotosResponse(

    val id: String?,

    val title: String?,

    val url: String?,

    @field:SerializedName("thumbnailUrl")
    val thumbnailUrl: String?
)