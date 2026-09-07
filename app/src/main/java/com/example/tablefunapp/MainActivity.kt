package com.example.tablefunapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tablefunapp.screens.SongSearch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.tablefunapp.screens.FrontPage
import com.example.tablefunapp.screens.SoundBoard
import com.example.tablefunapp.ui.BoardCueViewModel
import com.example.tablefunapp.ui.BoardViewModel
import com.example.tablefunapp.ui.SongSearchViewModel


import com.example.tablefunapp.ui.theme.TableFunAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TableFunAppTheme {
                MainScreen()
            }

        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: SongSearchViewModel = viewModel(),
    cueviewModel: BoardCueViewModel = viewModel(),
    boardViewModel: BoardViewModel = viewModel()
) {
    val navController = rememberNavController()
    val songs = viewModel.songs.value
    val errorMessage = viewModel.errorMessage.value

    NavHost(
        navController = navController,
        startDestination = NavRoutes.FrontPage.route
    ) {
        composable(NavRoutes.FrontPage.route) {
            FrontPage(
                modifier = modifier,
                boards = boardViewModel.boards.value,
                onBoardClick = { board ->
                    navController.navigate(NavRoutes.SoundBoard.route + "/${board.id}")
                }
            )
        }


        composable(
            NavRoutes.SoundBoard.route + "/{boardId}",
            arguments = listOf(navArgument("boardId") { type = NavType.IntType })
        ) { backStackEntry ->
            val boardId = backStackEntry.arguments?.getInt("boardId") ?: 0
            cueviewModel.loadBoard(boardId)

            SoundBoard(
                cues = cueviewModel.cues.value,
                onShortTap = { cue -> cueviewModel.playShort(cue) },
                onLongTap = { cue -> cueviewModel.playLong(cue) },
                onNext = { cueviewModel.playNext() },
                onBack = { cueviewModel.playBack() },
                onStop = { cueviewModel.onStop() },
                playingLongCueId = cueviewModel.playingLongCueId.value,
                playingShortCueId = cueviewModel.playingShortCueId.value
            )
        }

        composable(NavRoutes.SongSearch.route) {
            SongSearch(
                modifier = modifier,
                songs = songs,
                errorMessage = errorMessage,
                songsLoading = viewModel.isLoadingSongs.value,
                onSearch = { query -> viewModel.search(query) }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TableFunAppTheme {
        MainScreen()
    }
}