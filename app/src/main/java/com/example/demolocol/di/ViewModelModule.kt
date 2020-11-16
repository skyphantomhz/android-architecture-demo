package com.example.demolocol.di

import com.example.demolocol.feature.detail.DetailViewModel
import com.example.demolocol.feature.home.HomeViewModel
import com.example.demolocol.feature.profile.ProfileViewModel
import com.example.demolocol.feature.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { DetailViewModel() }
    viewModel { SearchViewModel(get()) }
    viewModel { ProfileViewModel() }
}