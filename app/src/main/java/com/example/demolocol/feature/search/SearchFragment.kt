package com.example.demolocol.feature.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.ui.PaginationListener
import com.example.data.vo.Error
import com.example.data.vo.Loading
import com.example.data.vo.Success
import com.example.demolocol.R
import com.example.demolocol.base.BaseFragment
import kotlinx.android.synthetic.main.search_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment() {

    private val searchViewModel: SearchViewModel by viewModel()
    private val repoAdapter = RepoAdapter{
        val navHost = childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return@RepoAdapter
        navHost.navController.navigate(R.id.action_homeFragment_to_detailFragment)
    }
    private val layoutManager = LinearLayoutManager(context)

    private var currentPage: Int = PaginationListener.PAGE_START
    private val isLastPage = false
    private val totalPage = 10
    private var isLoading = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_repo.layoutManager = layoutManager
        rv_repo.adapter = repoAdapter.apply {

        }


        view.findViewById<SearchView>(R.id.sv_repo).also {
            it.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    searchViewModel.searchRepo(query)
                    return true
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    searchViewModel.onQueryTextChange(query)
                    return true
                }

            })
        }

        searchViewModel.repos.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Loading -> {
                }
                is Success -> repoAdapter.setData(it.data)
                is Error -> {
                    repoAdapter.setData(emptyList())
                }
            }
        })

        searchViewModel.moreRepo.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Loading -> {
                }
                is Success -> {
                    repoAdapter.addData(it.data)
                    isLoading = false
                }
                is Error -> {
                }
            }
        })

        rv_repo.addOnScrollListener(object : PaginationListener(layoutManager) {
            override fun isLastPage(): Boolean {
                return this@SearchFragment.isLastPage
            }

            override fun loadMoreItems() {
                this@SearchFragment.isLoading = true
                repoAdapter.addLoading()
                searchViewModel.nextPage(++this@SearchFragment.currentPage)
            }

            override fun isLoading(): Boolean {
                return this@SearchFragment.isLoading
            }
        });
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }

}