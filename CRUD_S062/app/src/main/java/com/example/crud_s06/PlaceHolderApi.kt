package com.example.crud_s06

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceHolderApi {

    @GET("photos/{id}")
    fun getPhotos(@Path("id") id:Int):Call<Photos>

}