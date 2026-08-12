package com.example.tablefunapp.repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SongRepository {
    private val baseUrl = "https://www.googleapis.com/"

    private val songService: SongService

    init {
        val build: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()) //translate JSON to DTOer with Gson
            .build()
        songService = build.create(SongService::class.java)

    }

}