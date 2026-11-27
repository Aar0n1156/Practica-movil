package com.aaron.practica_mobil.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import com.aaron.practica_mobil.data.model.Song
import com.aaron.practica_mobil.ui.components.SongBox

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SongListScreen(
    songs: List<Song>,
    currentSongId: Int?,
    isLoading: Boolean = false,
    onSongClick: (Song) -> Unit,
    modifier: Modifier = Modifier
){
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Canciones") }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            when {
                isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                songs.isEmpty() -> {
                    Text(
                        text = "No hay canciones para mostrar.",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                else -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(songs, key = {it.id}) { song ->
                            SongBox(
                                song = song,
                                isPlaying = song.id == currentSongId,
                                onClick = { onSongClick(song)}
                            )
                        }
                    }
                }
            }
        }
    }
}

val sampleSong = listOf(
    Song(id = 1, title = "In the end", artist = "LINKIN PARK", album = "Hybrid Theory"),
    Song(id = 2, title = "Hot Dog", artist = "Limp Bizkit", album = "Chocolate Starfish And The Hot Dog Flavored Water"),
    Song(id = 1, title = "The House Jack Built (Remastered)", artist = "Metallica", album = "Load (Remastered)")
)
