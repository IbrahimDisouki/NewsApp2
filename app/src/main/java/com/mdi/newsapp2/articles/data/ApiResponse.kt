package com.mdi.newsapp2.articles.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class ApiResponse(
    @SerialName("status") val status: String? = null,
    @SerialName("totalResults") val totalResults: Int? = null,
    @SerialName("code") val code: String? = null,
    @SerialName("message") val message: String? = null,
    @SerialName("articles") val articles: @RawValue List<Article>? = null
) : Parcelable