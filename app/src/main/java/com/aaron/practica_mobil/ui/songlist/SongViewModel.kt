package com.aaron.practica_mobil.ui.songlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aaron.practica_mobil.data.remote.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel(){
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState

    init {
        fetchSongs()
    }

    private fun fetchSongs() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val response = RetrofitClient.apiService.getSongs()
                _uiState.value = UiState.Success(response)
            }
            catch (e: Exception){
                _uiState.value = UiState.Error(e.localizedMessage ?:"Error Desconocido")
            }
        }
    }


}