package com.example.tablefunapp.repository
import com.example.tablefunapp.data.YouTubeSearchResponseDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface SongService {
    @GET("youtube/v3/search")
    fun searchSongs(
        @Query("q") query: String,
        @Query("key") apiKey: String,
        @Query("part") part: String = "snippet",
        @Query("type") type: String = "video",
        @Query("maxResults") maxResults: Int = 5
    ): Call<YouTubeSearchResponseDto>
}