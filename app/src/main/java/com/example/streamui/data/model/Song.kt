package com.example.streamui.data.model

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class Song (
    val id: String,
    val title: String,
    val artist: String,
    @DrawableRes val albumCover: Int,
    val isFavorite: Boolean = false
)