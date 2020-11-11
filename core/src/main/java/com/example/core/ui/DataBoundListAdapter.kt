package com.example.core.ui

import android.view.View
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import android.view.ViewGroup

abstract class DataBoundListAdapter<T>(
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, DataBoundViewHolder>(
    AsyncDifferConfig.Builder<T>(diffCallback)
        .build()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder {
        val binding = createView(parent)
        return DataBoundViewHolder(binding)
    }

    protected abstract fun createView(parent: ViewGroup): View

    override fun onBindViewHolder(holder: DataBoundViewHolder, position: Int) {
        bind(holder.view, getItem(position))
    }

    protected abstract fun bind(view: View, item: T)
}
