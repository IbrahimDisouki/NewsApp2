package com.mdi.newsapp2.articles.data

import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class ArticlesRemoteDataSource @Inject constructor(private val client: HttpClient) :
    IArticlesRemoteDataSource {
    override suspend fun getArticles(): ApiResponse {
        return client.get("top-headlines?sources=techcrunch")
    }
}