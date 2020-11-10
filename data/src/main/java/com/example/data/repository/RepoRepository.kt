package com.example.data.repository

import com.example.data.model.Repo
import retrofit2.http.Query

interface RepoRepository {
    suspend fun searchRepos(@Query("q") query: String): List<Repo>
}