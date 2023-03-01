package com.thallo.stage.componets.history

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.thallo.stage.database.bookmark.Bookmark
import com.thallo.stage.database.history.History
import com.thallo.stage.databinding.ItemBookmarkBinding
import mozilla.components.concept.storage.BookmarkNode
import mozilla.components.service.fxa.SyncEngine

class HistoryAdapter : ListAdapter<History, HistoryAdapter.ItemTestViewHolder>(HistoryListCallback) {
    lateinit var select: Select

    inner class ItemTestViewHolder(private val binding: ItemBookmarkBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(bean: History, mContext: Context){
            binding.textView9.text=bean.title
            binding.textView10.text=bean.url
            binding.bookmarkItem.setOnClickListener { bean.url?.let { it1 -> select.onSelect(it1) } }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemTestViewHolder {
        return ItemTestViewHolder(ItemBookmarkBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ItemTestViewHolder, position: Int) {
        //通过ListAdapter内部实现的getItem方法找到对应的Bean
        holder.bind(getItem(holder.adapterPosition),holder.itemView.context)

    }
    interface Select{
        fun onSelect(url: String)
    }

}