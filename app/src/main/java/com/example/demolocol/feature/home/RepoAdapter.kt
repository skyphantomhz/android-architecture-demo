package com.example.demolocol.feature.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.Repo
import com.example.demolocol.R

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.ViewHolder>(){

    private var repos = listOf<Repo>()

    fun setData(repos: List<Repo>){
        this.repos = repos
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bind(repo: Repo){
            itemView.findViewById<TextView>(R.id.tv_title).text = repo.full_name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = repos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repo = repos[position])
    }
}