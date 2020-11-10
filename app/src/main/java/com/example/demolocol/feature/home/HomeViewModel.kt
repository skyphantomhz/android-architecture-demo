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

    fun searchRepo(){
        viewModelScope.launch {
            repos.postValue(repoRepository.searchRepos("a"))
        }
    }
}