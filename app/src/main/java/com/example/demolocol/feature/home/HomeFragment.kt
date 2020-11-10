package com.example.demolocol.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.demolocol.R
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val repoAdapter = RepoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.rv_repo).also {
            it.adapter = repoAdapter
        }

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
            repoAdapter.setData(it)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}