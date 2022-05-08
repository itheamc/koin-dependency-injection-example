package com.itheamc.koinditutorial.koin_impl

import com.itheamc.koinditutorial.repository.MainRepository
import com.itheamc.koinditutorial.repository.MainRepositoryImpl
import com.itheamc.koinditutorial.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule = module {
    single<MainRepository> {
        MainRepositoryImpl()
    }
    viewModel {
        MainViewModel(get())
    }
}