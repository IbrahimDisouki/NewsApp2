package com.mdi.newsapp2.articles.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mdi.newsapp2.articles.data.Article
import com.mdi.newsapp2.databinding.AdapterArticleBinding

class ArticlesAdapter(
    private val items: MutableList<Article> = mutableListOf(),
    private val onItemClick: (item: Article) -> Unit
) :
    RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(private val viewBinding: AdapterArticleBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(item: Article) {
            viewBinding.root.setOnClickListener {
                onItemClick(item)
            }
            with(item) {
                viewBinding.ivImage.load(urlToImage)
                viewBinding.tvTitle.text = title
                viewBinding.tvDescription.text = description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        ArticleViewHolder(
            AdapterArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(items[holder.adapterPosition])
    }

    override fun getItemCount(): Int = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<Article>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearItems() {
        items.clear()
        notifyDataSetChanged()
    }

}