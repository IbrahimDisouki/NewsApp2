package com.mdi.newsapp2.articles.presentation

import android.os.Parcelable
import com.mdi.newsapp2.articles.data.Article
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ArticlesState(
    val articles: @RawValue List<Article>? = null,
    val error: Exception? = null
) : Parcelable