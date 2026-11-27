package com.aaron.practica_mobil.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LibraryMusic
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
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
    featuredSongs: List<Song> = sampleSong.take(2),
    recentSongs: List<Song> = sampleSong,
    currentSongId: Int? = null,
    onSongSelected: (Song) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val activeSong = (featuredSongs + recentSongs).find { it.id == currentSongId }

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
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Destacadas",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                TextButton(onClick = { navController.navigate("song_list") }) {
                    Text("Ver todas")
                }
            }

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(featuredSongs, key = { it.id }) { song ->
                    SongBox(
                        song = song,
                        isPlaying = song.id == currentSongId,
                        onClick = {
                            onSongSelected(song)
                            navController.navigate("player/${song.id}")
                        },
                        modifier = Modifier.width(280.dp)
                    )
                }
            }

            Text(
                text = "Escuchadas recientemente",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                recentSongs.forEach { song ->
                    SongBox(
                        song = song,
                        isPlaying = song.id == currentSongId,
                        onClick = {
                            onSongSelected(song)
                            navController.navigate("player/${song.id}")
                        }
                    )
                }
            }
        }
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