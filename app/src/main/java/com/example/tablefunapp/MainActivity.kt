package com.example.tablefunapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tablefunapp.screens.SongSearch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    viewModel: SongSearchViewModel = viewModel()
) {
    val navController = rememberNavController()
    val songs = viewModel.songs.value
    val errorMessage = viewModel.errorMessage.value

    NavHost(
        navController = navController,
        startDestination = NavRoutes.SongSearch.route
    ) {
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