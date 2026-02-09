package com.example.streamui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.streamui.ui.HighlightsScreen
import com.example.streamui.ui.SongScreen
import com.example.streamui.ui.navigation.Destination
import com.example.streamui.ui.theme.StreamUITheme
import com.example.streamui.viewmodel.SongViewModel
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StreamUITheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    // Se crea el ViewModel aqui para compartirlo entre pantallas.
    // Así los "Likes" se sincronizan automaticamente.
    val sharedViewModel: SongViewModel = koinViewModel()

    // Lista de pantallas para la barra de abajo.
    val items = listOf(
        Destination.Home,
        Destination.Highlights
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(screen.title) },
                        // Se pinta el boton si estamos en esa pantalla.
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Configuracion para que la navegación sea fluida.
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        // Aquí se define que pantalla se muestra.
        NavHost(
            navController = navController,
            startDestination = Destination.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Destination.Home.route) {
                // Se pasa el 'sharedViewModel'.
                SongScreen(viewModel = sharedViewModel)
            }
            composable(Destination.Highlights.route) {
                // Se le pasa el mismo 'sharedViewModel'.
                HighlightsScreen(viewModel = sharedViewModel)
            }
        }
    }
}