package com.example.demolocol.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core.extension.postValue
import com.example.data.model.Repo
import com.example.data.repository.RepoRepository
import com.example.demolocol.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(private val repoRepository: RepoRepository) : BaseViewModel() {

    var repos: LiveData<List<Repo>> = MutableLiveData()
    private var lastSearchTime = System.currentTimeMillis()
    private val debounceTime = 500


    fun searchRepo(query: String?) {
        if (query.isNullOrBlank()) return
        viewModelScope.launch {
            repos.postValue(repoRepository.searchRepos(query))
        }
    }

    fun onQueryTextChange(query: String?) {
        if (System.currentTimeMillis() - lastSearchTime > debounceTime) {
            searchRepo(query)
            lastSearchTime = System.currentTimeMillis()
        }
    }
}