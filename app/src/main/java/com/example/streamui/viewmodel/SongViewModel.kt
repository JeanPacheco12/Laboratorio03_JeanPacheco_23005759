package com.example.streamui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.streamui.data.model.Song
import com.example.streamui.data.repository.SongRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

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
        _songs.value = repository.getSongs()
    }
}