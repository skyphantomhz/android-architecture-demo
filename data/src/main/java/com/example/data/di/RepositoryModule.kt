package com.example.data.di

import com.example.data.model.datasource.RepoDataSource
import com.example.data.repository.RepoRepository
import org.koin.dsl.module

@JvmField
val repositoryModule = module {
    single<RepoRepository> { RepoDataSource(get()) }
}