package com.mdi.newsapp2.articles.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class ApiResponse(
    @SerialName("status") val status: String,
    @SerialName("articles") val articles: @RawValue List<Article>
) : Parcelable