package com.example.tablefunapp.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tablefunapp.models.Cue
import com.example.tablefunapp.R
import androidx.compose.ui.graphics.Color


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoundBoard(
    cues: List<Cue>,
    title: String = "",
    modifier: Modifier = Modifier,
    onShortTap: (Cue) -> Unit = {},
    onLongTap: (Cue) -> Unit = {},
    onNext: () -> Unit = {},
    onPrevious: () -> Unit = {},
    onStop: () -> Unit = {},
    onNavigateBack: () -> Unit = {},
    playingLongCueId: Int? = null,
    playingShortCueId: Int? = null
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text(title) },
                actions = {
                    FilledTonalIconButton(onClick = { onPrevious() }) {
                        Icon(
                            imageVector = Icons.Filled.SkipPrevious,
                            contentDescription = "Back!"
                        )
                    }
                    FilledTonalIconButton(onClick = { onStop() }) {
                        Icon(
                            imageVector = Icons.Filled.Stop,
                            contentDescription = "Next!"
                        )
                    }
                    FilledTonalIconButton(onClick = { onNext() }) {
                        Icon(
                            imageVector = Icons.Filled.SkipNext,
                            contentDescription = "Next!"
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { onNavigateBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Tilbage"
                        )
                    }
                },
            )
        }) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp),
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
                    onLongTap = { onLongTap(cue) },
                    isPlayingLong = cue.id == playingLongCueId,
                    isPlayingShort = cue.id == playingShortCueId
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
    onLongTap: () -> Unit,
    isPlayingLong: Boolean = false,
    isPlayingShort: Boolean = false
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.5f)
            .combinedClickable(
                onClick = { onShortTap() },
                onDoubleClick = { onLongTap() }
            )
            .cueAnimation(cue.animation, isPlayingLong || isPlayingShort)
    ) {
        Box {
            Image(
                painter = painterResource(id = cue.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            //Dark gradient for readability
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.15f),
                                Color.Black.copy(alpha = 0.55f)
                            )
                        )
                    )
            )

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
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
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
            Cue(1, "Kristian", 0, emptyList(), "Mugge", image = R.drawable.revenge),
            Cue(2, "Jonas C", 0, emptyList(), "", image = R.drawable.vakuu),
            Cue(3, "Lassen", 0, emptyList(), "", image = R.drawable.leende_ko_classic),
            Cue(4, "Jonas S", 0, emptyList(), "", image = R.drawable.senshi),
            Cue(5, "Shop", 0, emptyList(), "", image = R.drawable.slay_shoopkeeper),
            Cue(6, "SideQuest", 0, emptyList(), "", image = R.drawable.sidequest)
        )
    )
}