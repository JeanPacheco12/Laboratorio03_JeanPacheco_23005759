package com.example.streamui.di

import com.example.streamui.data.repository.SongRepository
import org.koin.dsl.module

val appModule = module {
    // Aqui le vamos a enseñar a la app a como crear el repositorio.
    // "single" es como decir que crea una sola instancia para toda la app (sirve para el ahorro de memoria).
    single { SongRepository() }
}

