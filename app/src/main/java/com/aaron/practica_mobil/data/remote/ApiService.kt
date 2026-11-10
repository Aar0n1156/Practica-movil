package com.aaron.practica_mobil.data.remote

import com.aaron.practica_mobil.data.model.Song
import retrofit2.http.GET

interface ApiService {
    @GET("/api/songs")
    suspend fun getSongs(): List<Song>
}