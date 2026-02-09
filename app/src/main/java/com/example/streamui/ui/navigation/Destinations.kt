package com.example.streamui.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

// Se define una plantilla de rutas.
sealed class Destination(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    // Home (lista completa).
    object Home : Destination(
        route = "home",
        title = "Home",
        icon = Icons.Filled.Home
    )

    // Highlights (Solo para favoritos).
    object Highlights : Destination(
        route = "highlights",
        title = "Highlights",
        icon = Icons.Filled.Star
    )
}