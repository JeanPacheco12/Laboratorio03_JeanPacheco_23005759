package com.example.streamui.data.repository

import com.example.streamui.data.model.Song
import com.example.streamui.R

class SongRepository {
    // Modificacion de imagen.
    private val songList = listOf(
        Song(
            id = "1",
            title = "Animal I Have Become",
            artist = "Three Days Grace",
            albumCover = R.drawable.animal_i_have_become,
            isFavorite = true
        ),
        Song(
            id = "2",
            title = "American Idiot",
            artist = "Green Day",
            albumCover = R.drawable.american_idiot
        ),
        Song(
            id = "3",
            title = "Break Stuff",
            artist = "Limp Bizkit",
            albumCover = R.drawable.break_stuff
        ),
        Song(
            id = "4",
            title = "Numb",
            artist = "Linkin Park",
            albumCover = R.drawable.numb
        ),
        Song(
            id = "5",
            title = "In The End",
            artist = "Linkin Park",
            albumCover = R.drawable.i_the_end,
            isFavorite = true
        ),
        Song(
            id = "6",
            title = "Last Resort",
            artist = "Papa Roach",
            albumCover = R.drawable.papa_roach
        )
    )

    fun getSongs() : List<Song> {
        return songList
    }
}