package com.example.tablefunapp.repository

import com.example.tablefunapp.BuildConfig
import com.example.tablefunapp.data.SearchItemDto
import com.example.tablefunapp.data.YouTubeSearchResponseDto
import com.example.tablefunapp.data.toSong
import com.example.tablefunapp.models.Song
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

class YouTubeRepository {
    private val baseUrl = "https://www.googleapis.com/"

    private val songService: SongService

    init {
        val build: Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create()) //translate JSON to DTOer with Gson
            .build()
        songService = build.create(SongService::class.java)
    }

    fun searchSong(
        query: String,
        onResult: (List<Song>) -> Unit,
        onError: (String) -> Unit,
    ) {
        songService.searchSongs(query, BuildConfig.YOUTUBE_API_KEY)
            .enqueue(object : Callback<YouTubeSearchResponseDto> {
                override fun onResponse(
                    call: Call<YouTubeSearchResponseDto?>,
                    response: Response<YouTubeSearchResponseDto?>
                ) {
                    if (response.isSuccessful) {
                        val body: YouTubeSearchResponseDto? = response.body() //JSON as an object
                        val item = body?.items ?: emptyList()
                        val song = item.mapNotNull {it.toSong()}
                        onResult(song)
                    } else {
                        onError("${response.code()} ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<YouTubeSearchResponseDto?>, t: Throwable) {
                    val message = t.message ?: "No connection to Back.end"
                    onError(message)

                }
            })


    }

}