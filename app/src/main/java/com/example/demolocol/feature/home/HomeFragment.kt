package com.example.demolocol.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.core.ui.PaginationListener
import com.example.core.ui.PaginationListener.PAGE_START
import com.example.data.vo.Error
import com.example.data.vo.Loading
import com.example.data.vo.Success
import com.example.demolocol.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val repoAdapter = RepoAdapter()
    private val layoutManager = LinearLayoutManager(context)

    private var currentPage: Int = PAGE_START
    private val isLastPage = false
    private val totalPage = 10
    private var isLoading = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_repo.layoutManager = layoutManager
        rv_repo.adapter = repoAdapter


        view.findViewById<SearchView>(R.id.sv_repo).also {
            it.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    homeViewModel.searchRepo(query)
                    return true
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    homeViewModel.onQueryTextChange(query)
                    return true
                }

            })
        }

        homeViewModel.repos.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Loading -> {
                }
                is Success -> repoAdapter.setData(it.data)
                is Error -> {
                    repoAdapter.setData(emptyList())
                }
            }
        })

        homeViewModel.moreRepo.observe(viewLifecycleOwner, Observer {
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
                return this@HomeFragment.isLastPage
            }

            override fun loadMoreItems() {
                this@HomeFragment.isLoading = true
                repoAdapter.addLoading()
                homeViewModel.nextPage(++this@HomeFragment.currentPage)
            }

            override fun isLoading(): Boolean {
                return this@HomeFragment.isLoading
            }
        });
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}