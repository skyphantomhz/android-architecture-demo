package com.example.demolocol.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.extension.postValue
import com.example.data.model.Repo
import com.example.data.repository.RepoRepository
import com.example.data.vo.Resource
import com.example.demolocol.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(private val repoRepository: RepoRepository) : BaseViewModel() {

    var repos: LiveData<Resource<List<Repo>>> = MutableLiveData<Resource<List<Repo>>>()
    var moreRepo: LiveData<Resource<List<Repo>>> = MutableLiveData<Resource<List<Repo>>>()
    private var lastSearchTime = System.currentTimeMillis()
    private val debounceTime = 500
    private var lastQuery: String = ""


    fun searchRepo(query: String?) {
        if (query.isNullOrBlank()) return
        viewModelScope.launch {
            lastQuery = query
            val data = repoRepository.searchRepo(query, 0)
            repos.postValue(data)
        }
    }

    fun onQueryTextChange(query: String?) {
        if (System.currentTimeMillis() - lastSearchTime > debounceTime) {
            searchRepo(query)
            lastSearchTime = System.currentTimeMillis()
        }
    }

    fun nextPage(page: Int) {
        viewModelScope.launch {
            val nextData = repoRepository.searchRepo(lastQuery, page)
            moreRepo.postValue(nextData)
        }
    }
}