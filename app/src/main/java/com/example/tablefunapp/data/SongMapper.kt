package com.example.tablefunapp.data

import com.example.tablefunapp.models.Song
//extension function -  testing the logic from mapping from DTO to Song model
fun SearchItemDto.toSong(): Song? {
    val id = this.id?.videoId ?: return null
    return Song(
        id = id,
        title = snippet?.title ?: "Uden titel",
        channelTitle = snippet?.channelTitle ?: "",
        thumbnailUrl = snippet?.thumbnails?.high?.url
            ?: snippet?.thumbnails?.medium?.url
            ?: snippet?.thumbnails?.defaultThumb?.url
            ?: ""
    )
}