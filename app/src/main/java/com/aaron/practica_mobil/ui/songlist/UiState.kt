package com.aaron.practica_mobil.ui.songlist

import com.aaron.practica_mobil.data.model.Song

sealed interface UiState {
    object Loading : UiState
    data class Success(val song: List<Song>) : UiState
    data class Error(val message: String) : UiState
}