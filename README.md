# StreamUI - Android Music Player App

StreamUI es una aplicación nativa de Android desarrollada con **Jetpack Compose**, diseñada para listar, buscar y gestionar canciones favoritas utilizando una arquitectura moderna y escalable.

Este proyecto fue desarrollado como parte del **Laboratorio de UI Avanzada y Navegación**.

## Características Principales

* **Listado de Canciones:** Visualización eficiente de listas con `LazyColumn`.
* **Sistema de Favoritos:** Capacidad para marcar/desmarcar canciones como favoritas.
    * *Estado Compartido:* Los cambios en "Home" se reflejan inmediatamente en "Highlights".
* **Navegación (Bottom Navigation):**
    * **Home:** Lista completa de canciones con buscador.
    * **Highlights:** Vista filtrada solo con las canciones favoritas.
* **Buscador en Tiempo Real:** Barra de búsqueda funcional que filtra por artista o título.
* **UI Moderna:** Uso de Material Design 3, carátulas de álbumes reales y componentes personalizados.

## Tecnologías y Arquitectura

El proyecto sigue una arquitectura **MVVM (Model-View-ViewModel)** limpia:

* **Lenguaje:** Kotlin.
* **UI Toolkit:** Jetpack Compose (Material 3).
* **Inyección de Dependencias:** [Koin](https://insert-koin.io/).
* **Navegación:** Jetpack Compose Navigation (`androidx.navigation`).
* **Gestión de Estado:** Kotlin Coroutines & StateFlow.

### Estructura del Proyecto

* `data/`: Contiene el Modelo (`Song`) y el Repositorio (`SongRepository`) que simula la fuente de datos.
* `di/`: Módulo de Koin para la inyección de dependencias.
* `ui/`: Pantallas (`SongScreen`, `HighlightsScreen`), componentes y configuración de temas.
* `ui/navigation/`: Configuración del `NavHost` y destinos (`Destinations`).
* `viewmodel/`: `SongViewModel` que gestiona la lógica de negocio y el estado compartido.

---

## Demostración y Explicación

[ **https://youtu.be/Jkk-9HcnE5U** ]
