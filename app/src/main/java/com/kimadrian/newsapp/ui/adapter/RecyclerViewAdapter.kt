package com.kimadrian.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kimadrian.newsapp.R
import com.kimadrian.newsapp.data.model.Article
import com.kimadrian.newsapp.ui.view.HomeFragmentDirections

class RecyclerViewAdapter: ListAdapter<Article, NewsViewHolder>(DiffCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = getItem(position)
        holder.newsSource.text = newsItem.source?.name
        holder.desc.text = newsItem.description
        holder.title.text = newsItem.title
        Glide.with(holder.newsImage.context)
            .load(newsItem.urlToImage)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .centerCrop()
            .into(holder.newsImage)
        holder.newsCards.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(HomeFragmentDirections
                    .actionHomeFragmentToWebPageFragment(newsItem.url!!))
        }
    }

    companion object DiffCallBack: DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }
}

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val desc: TextView = itemView.findViewById(R.id.description)
    val title: TextView = itemView.findViewById(R.id.title)
    val newsCards: CardView = itemView.findViewById(R.id.newsCard)
    val newsSource: TextView = itemView.findViewById(R.id.newsSource)
    val newsImage: ImageView = itemView.findViewById(R.id.newsImage)

}


