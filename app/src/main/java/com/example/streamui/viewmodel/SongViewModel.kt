package com.example.streamui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.streamui.data.model.Song
import com.example.streamui.data.repository.SongRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// El ViewModel va a recibir al repositorio (se mira como si fuera una cocina).
class SongViewModel(private val repository: SongRepository) : ViewModel() {

    // _songs es la lista privada y modificable (o sea, mutable)
    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    // songs a diferencia de la anterior lista, esta sera publica y vera la pantalla (o sea, inmutable y de solo lectura)
    val songs : StateFlow<List<Song>> = _songs.asStateFlow()

    init {
        // A penas se genera el ViewModel, se cargan las canciones
        loadSongs()
    }

    private fun loadSongs() {
        viewModelScope.launch {
            _songs.value = repository.getSongs()
        }
    }

    // Aplicacion nueva
    fun toggleFavorite(song: Song) {
        // Se recorre la lista actual y se modifica solo la cancion que se toco.
        _songs.value = _songs.value.map { currentSong ->
            if (currentSong.id == song.id) {
                // Se crea una copia con el valor de favorito invertido.
                currentSong.copy(isFavorite = !currentSong.isFavorite)
            } else {
                currentSong
            }
        }
    }
}