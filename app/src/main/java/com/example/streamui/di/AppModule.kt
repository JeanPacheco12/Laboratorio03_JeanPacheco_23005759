package com.example.streamui.di

import com.example.streamui.data.repository.SongRepository
import com.example.streamui.viewmodel.SongViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Aqui le vamos a enseñar a la app a como crear el repositorio.
    // "single" es como decir que crea una sola instancia para toda la app (sirve para el ahorro de memoria), Koin va a aprender a crear el repositorio.
    single { SongRepository() }

    // Aqui Koin va a aprender a crear el viewmodel.
    //get() dice: Busca el repositorio que definimos arriba y usalo aqui.
    viewModel { SongViewModel(get()) }
}

