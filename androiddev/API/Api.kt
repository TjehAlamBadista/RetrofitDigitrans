package com.example.androiddev.API

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("photos")
    fun getPhotos() : Call<ArrayList<PhotosResponse>>
}