package com.mdi.newsapp2.articles.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Article(
    val title: String,
    val description: String,
    val urlToImage: String,
    val content: String
) : Parcelable