package com.example.demolocol.di

import com.example.demolocol.feature.detail.DetailViewModel
import com.example.demolocol.feature.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel() }
}