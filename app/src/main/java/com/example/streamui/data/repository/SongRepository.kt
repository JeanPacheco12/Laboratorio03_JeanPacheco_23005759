package com.example.streamui.data.repository

// Librerias para funcionamiento de la data de streamUI

import com.example.streamui.data.model.Song
import com.example.streamui.R

class SongRepository {
    // Base de datos con canciones de prueba
    val songs = listOf(
        Song("1", "Animal I Have Become", "Three Days Grace", R.drawable.ic_launcher_background, isFavorite = true),
        Song("2", "American Idiot", "Green Day", R.drawable.ic_launcher_foreground),
        Song("3", "Break Stuff", "Limp Bizkit", R.drawable.ic_launcher_background),
        Song("4", "Numb", "Sleep Theory", R.drawable.ic_launcher_foreground),
        Song("5", "In The End", "Linkin Park", R.drawable.ic_launcher_background, isFavorite = true),
        Song("6", "Last Resort", "Papa Roach", R.drawable.ic_launcher_foreground)
    )

    fun getSongs() : List<Song> {
        return songs;
    }

    fun getFavorites() : List<Song> {
        return songs.filter { it.isFavorite }
    }
}