package com.example.appsuperzound

import retrofit2.Call
import retrofit2.http.GET

interface PlaceHolderApi {

    @GET("mostloved.php?format=album")
    fun getAllAlbums(): Call<AlbumResponse>
}