package com.example.streamui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.example.streamui.viewmodel.SongViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HighlightsScreen(viewModel: SongViewModel = koinViewModel()) {
    val songs by viewModel.songs.collectAsState()
    val favoriteSongs = songs.filter { it.isFavorite }

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(favoriteSongs) { song ->
            SongItem(
                song = song,
                onFavoriteClick = { viewModel.toggleFavorite(song) }
            )
        }
    }
}