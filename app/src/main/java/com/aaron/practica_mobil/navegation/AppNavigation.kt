package com.aaron.practica_mobil.navegation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aaron.practica_mobil.screens.LoginScreen
import com.aaron.practica_mobil.screens.MainScreen
import com.aaron.practica_mobil.screens.PermissionScreen
import com.aaron.practica_mobil.screens.SignUpScreen
import com.aaron.practica_mobil.screens.WellcomeScreen
import com.aaron.practica_mobil.screens.sampleSong
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.aaron.practica_mobil.screens.SongListScreen
import com.aaron.practica_mobil.ui.screens.PlayerScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val songs = sampleSong
    var currentSongId by remember { mutableStateOf<Int?>(songs.firstOrNull()?.id) }
    var isPlaying by remember { mutableStateOf(false) }
    var progress by remember { mutableStateOf(0) }

    NavHost(
        navController = navController,
        startDestination =  "welcome"
    ){
        composable("welcome"){
            WellcomeScreen(navController)
        }
        composable("login") {
            LoginScreen(navController)
        }
        composable ("signup"){
            SignUpScreen(navController)
        }
        composable ("main"){
            MainScreen(
                navController = navController,
                featuredSongs = songs.take(2),
                recentSongs = songs,
                currentSongId = currentSongId,
                onSongSelected = { song ->
                    currentSongId = song.id
                    isPlaying=true
                }
            )
        }
        composable ("permission"){
            PermissionScreen(navController)
        }
        composable(route = "song_list"){
            SongListScreen(
                songs = songs,
                currentSongId = currentSongId,
                onSongClick = { song ->
                    currentSongId = song.id
                    isPlaying = true
                    navController.navigate("player/${song.id}")
                }
            )
        }
        composable(
            route = "player/{songId}",
            arguments = listOf(navArgument("songId") { type = NavType.IntType })
        ) { backStackEntry ->
            val songId = backStackEntry.arguments?.getInt("songId")
            val activeSong = songs.find { it.id == songId } ?: songs.find { it.id == currentSongId }

            PlayerScreen(
                song = activeSong,
                isPlaying = isPlaying,
                progressFraction = progress / 100f,
                onBack = { navController.popBackStack() },
                onTogglePlayPause = { isPlaying = !isPlaying },
                onPrevious = {
                    activeSong?.let { current ->
                        val idx = songs.indexOfFirst { it.id == current.id }
                        if (idx > 0) {
                            val prev = songs[idx - 1]
                            currentSongId = prev.id
                            navController.navigate("player/${prev.id}") {
                                popUpTo("player/{songId}") { inclusive = true }
                            }
                        }
                    }
                },
                onNext = {
                    activeSong?.let { current ->
                        val idx = songs.indexOfFirst { it.id == current.id }
                        if (idx != -1 && idx < songs.lastIndex) {
                            val next = songs[idx + 1]
                            currentSongId = next.id
                            navController.navigate("player/${next.id}") {
                                popUpTo("player/{songId}") { inclusive = true }
                            }
                        }
                    }
                },
                onSeek = { fraction ->
                    progress = (fraction * 100).toInt()
                }
            )
        }
    }
}