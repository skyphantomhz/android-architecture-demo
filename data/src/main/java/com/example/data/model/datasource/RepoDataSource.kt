package com.example.data.model.datasource

import com.example.data.api.service.RepoService
import com.example.data.model.Repo
import com.example.data.repository.RepoRepository

class RepoDataSource(private val repoService: RepoService) : RepoRepository {

    override suspend fun searchRepos(query: String): List<Repo> {
        return repoService.searchRepos(query).items
    }
}