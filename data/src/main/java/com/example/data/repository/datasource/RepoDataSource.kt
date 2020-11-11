package com.example.data.repository.datasource

import com.example.data.api.service.RepoService
import com.example.data.model.Repo
import com.example.data.repository.RepoRepository
import com.example.data.utils.networkBoundResource
import com.example.data.vo.Resource

class RepoDataSource(
    private val repoService: RepoService
) : RepoRepository {

    override suspend fun searchRepo(query: String, page: Int): Resource<List<Repo>> {
        return networkBoundResource(repoService.searchRepos(query, page)::items)
    }
}