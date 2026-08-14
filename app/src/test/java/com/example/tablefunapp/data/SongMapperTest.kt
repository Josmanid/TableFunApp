package com.example.tablefunapp.data
import org.junit.Assert.assertNull
import org.junit.Assert.assertEquals
import org.junit.Test


class SongMapperTest {

    @Test
    fun `Item without videoId result in null `() {
        val item = SearchItemDto(
            id = VideoIdDto(kind = "youtube#video", videoId = null),
            snippet = null
        )
        assertNull(item.toSong())
    }

    @Test
    fun `Item thumbnail have medium url bu not high url `(){
        val item = SearchItemDto(
            id = VideoIdDto(kind = "youtube#video", videoId = "testnotNull"),
            snippet = SnippetDto(
                title = null,
                channelTitle = null,
                description = null,
                publishedAt = null,
                thumbnails = ThumbnailsDto(defaultThumb = null,
                    medium = ThumbnailDto(url = "https://test.dk/medium.jpg", width = 320, height = 180),
                    high = null
                )
            )

        )

        assertEquals("https://test.dk/medium.jpg",item.toSong()?.thumbnailUrl)
    }
}