package com.aaron.practica_mobil.screens

import android.adservices.adid.AdId
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LibraryMusic
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aaron.practica_mobil.data.model.Song
import com.aaron.practica_mobil.ui.components.SongBox
import com.aaron.practica_mobil.ui.theme.Practica_MobilTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    featuredSong: List<Song> = sampleSong.take(2),
    recentSongs : List<Song> = sampleSong,
    currentSongId: Int? = null,
    modifier: Modifier = Modifier
){
    val activeSong = (featuredSong + recentSongs).find { it.id == currentSongId }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Inicio") },
                actions = {
                    IconButton(onClick = { navController.navigate("song_list") }) {
                        Icon(
                            imageVector = Icons.Rounded.LibraryMusic,
                            contentDescription = "Ver todas las canciones"
                        )
                    }
                }
            )
        },
        bottomBar = {
            if (activeSong != null) {
                Surface(
                    tonalElevation = 8.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    SongBox(
                        song = activeSong,
                        isPlaying = true,
                        onClick = { navController.navigate("player/${activeSong.id}") },
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                    )
                }
            }
        }
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(vertical = 16.dp)
        ) { }

    }
}

@Preview(showBackground = true)
@Composable
fun MainSPreview(){
    Practica_MobilTheme{
        val navController = rememberNavController()
        MainScreen(navController)
    }
}