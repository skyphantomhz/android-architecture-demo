package com.example.data.repository.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.model.Repo
import com.example.data.utils.Converters

@Database(entities = [Repo::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun repoDao(): RepoDao
}

const val DATABASE_NAME = "repo-db"