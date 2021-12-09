package com.mdi.newsapp2.articledetails.presentation

import android.os.Parcelable
import com.mdi.newsapp2.articles.data.Article
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleDetailsState(val article: Article? = null) : Parcelable