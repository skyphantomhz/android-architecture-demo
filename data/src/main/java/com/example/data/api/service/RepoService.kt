package com.example.data.api.service

import com.example.data.api.Endpoint.SEARCH_REPO
import com.example.data.model.response.RepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RepoService {

    @GET(SEARCH_REPO)
    suspend fun searchRepos(@Query("q") query: String): RepoSearchResponse
}