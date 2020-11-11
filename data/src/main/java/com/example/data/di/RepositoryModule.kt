package com.example.data.di

import androidx.room.Room
import com.example.data.repository.RepoRepository
import com.example.data.repository.datasource.RepoDataSource
import com.example.data.repository.datasource.local.AppDatabase
import com.example.data.repository.datasource.local.DATABASE_NAME
import org.koin.dsl.module

@JvmField
val repositoryModule = module {

    single { Room.databaseBuilder(get(), AppDatabase::class.java, DATABASE_NAME).build() }

    single { get<AppDatabase>().repoDao() }

    single<RepoRepository> {
        RepoDataSource(
            get()
        )
    }
}