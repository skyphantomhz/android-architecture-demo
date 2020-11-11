package com.example.demolocol.feature.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.Repo
import com.example.demolocol.R


class RepoAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_LOADING = 0
    private val VIEW_TYPE_NORMAL = 1
    private var isLoaderVisible = false

    private var repos = mutableListOf<Repo?>()

    fun setData(repos: List<Repo>) {
        this.repos = repos.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (isLoaderVisible) {
            if (position == repos.size - 1) VIEW_TYPE_LOADING else VIEW_TYPE_NORMAL
        } else {
            VIEW_TYPE_NORMAL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_NORMAL -> ItemHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_repo, parent, false)
            )
            else -> ProgressHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_loading, parent, false)
            )
        }
    }

    fun addLoading() {
        isLoaderVisible = true
        repos.add(null)
        notifyItemInserted(repos.size - 1)
    }

    fun removeLoading() {
        isLoaderVisible = false
        val position: Int = repos.size - 1
        val item: Repo? = getItem(position)
        if (item == null) {
            repos.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    private fun getItem(position: Int): Repo? {
        return repos[position]
    }

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemHolder) {
            repos[position]?.let {
                holder.bind(repo = it)
            }
        }
    }

    fun addData(data: List<Repo>) {
        removeLoading()
        repos.addAll(data)
    }

    inner class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(repo: Repo) {
            itemView.findViewById<TextView>(R.id.tv_title).text = repo.full_name
        }
    }

    inner class ProgressHolder(view: View) : RecyclerView.ViewHolder(view) {}
}