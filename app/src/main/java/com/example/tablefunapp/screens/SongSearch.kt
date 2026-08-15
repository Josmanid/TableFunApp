package com.example.tablefunapp.screens

import android.os.Message
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tablefunapp.models.Song

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SongSearch(
    songs: List<Song>,
    modifier: Modifier = Modifier,
    errorMessage: String = "",
    songsLoading: Boolean = false,
    onSearch: (String) -> Unit = {}
) {
    var query by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("Søg tema") })
        }) { innerPadding ->

        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)) {

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Søgeord") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { onSearch(query) },
                enabled = query.isNotBlank() && !songsLoading
            ) {
                Text("Søg")
            }

            when {
                songsLoading -> CircularProgressIndicator()

                errorMessage.isNotEmpty() -> Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error
                )

                else -> LazyColumn {
                    items(songs) { song ->
                        Column(Modifier.padding(vertical = 8.dp)) {
                            Text(song.title, style = MaterialTheme.typography.titleMedium)
                            Text(song.channelTitle, style = MaterialTheme.typography.bodySmall)

                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SongSearchPreview() {
    SongSearch(
        songs = listOf(Song("abc", "Pepsi Man Theme Song", "Rizu Drums", ""))
    )
}