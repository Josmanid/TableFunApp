package com.example.tablefunapp.data
import com.google.gson.annotations.SerializedName
class YouTubeDto {


    /**
     * disse er formet efter api.
     * Disse klasser findes KUN for at Gson kan parse JSON.
     * Resten af appen bruger models.Song
     */

    data class YouTubeSearchResponseDto(
        val nextPageToken: String?,
        val items: List<SearchItemDto>?
    )

    data class SearchItemDto(
        val id: VideoIdDto?,
        val snippet: SnippetDto?
    )

    data class VideoIdDto(
        val kind: String?,
        val videoId: String?
    )

    data class SnippetDto(
        val title: String?,
        val channelTitle: String?,
        val description: String?,
        val publishedAt: String?,
        val thumbnails: ThumbnailsDto?
    )

    data class ThumbnailsDto(
        @SerializedName("default") val defaultThumb: ThumbnailDto?,
        val medium: ThumbnailDto?,
        val high: ThumbnailDto?
    )

    data class ThumbnailDto(
        val url: String?,
        val width: Int?,
        val height: Int?
    )


}