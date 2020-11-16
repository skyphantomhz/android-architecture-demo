package com.example.demolocol.feature.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.demolocol.R
import com.example.demolocol.base.BaseFragment
import com.example.demolocol.feature.profile.ProfileFragment
import com.example.demolocol.feature.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HomeAdapter(
            childFragmentManager, FragmentStatePagerAdapter.POSITION_NONE,
            listOf(SearchFragment.newInstance(), ProfileFragment.newInstance())
        )
        bnv_home.setOnNavigationItemSelectedListener(this)
        vp_home.adapter = adapter

    }




    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        vp_home.currentItem = when (menuItem.itemId) {
            R.id.searchFragment -> 0
            else -> 1
        }
        return true
    }
}

class HomeAdapter(
    fragmentManager: FragmentManager,
    behavior: Int,
    private val fragments: List<Fragment>
) : FragmentStatePagerAdapter(fragmentManager, behavior) {
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int = fragments.size
}