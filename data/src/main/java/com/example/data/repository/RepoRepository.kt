package com.example.data.repository

import com.example.data.model.Repo
import com.example.data.vo.Resource

interface RepoRepository {
    suspend fun searchRepo(query: String, page: Int): Resource<List<Repo>>
}