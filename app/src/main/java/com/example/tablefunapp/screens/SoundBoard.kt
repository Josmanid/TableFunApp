package com.example.tablefunapp.screens

import android.R
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tablefunapp.models.Cue


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoundBoard(
    cues: List<Cue>,
    modifier: Modifier = Modifier,
    onShortTap: (Cue) -> Unit = {},
    onLongTap: (Cue) -> Unit = {}
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("Team Sexy") }
            )
        }) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(innerPadding)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(cues) { cue ->
                CueBlock(
                    cue = cue,
                    onShortTap = { onShortTap(cue) },
                    onLongTap = { onLongTap(cue) }
                )
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CueBlock(
    cue: Cue,
    onShortTap: () -> Unit,
    onLongTap: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .combinedClickable(
                onClick = { onShortTap() },
                onDoubleClick = { onLongTap() }
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = cue.name,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center
            )
            if (cue.longTitle.isNotEmpty()) {
                Text(
                    text = cue.longTitle,
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SoundBoardPreview() {
    SoundBoard(
        cues = listOf(
            Cue(1, "Jonas", 0, 0, "Mugge"),
            Cue(2, "Spiller 2", 0, 0, ""),
            Cue(3, "Spiller 3", 0, 0, "Pepsi Man Theme"),
            Cue(4, "Spiller 4", 0, 0, ""),
            Cue(5, "Shop", 0, 0, "")
        )
    )
}