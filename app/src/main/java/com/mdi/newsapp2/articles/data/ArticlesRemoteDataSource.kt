package com.mdi.newsapp2.articles.data

import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject

class ArticlesRemoteDataSource @Inject constructor(private val client: HttpClient) :
    IArticlesRemoteDataSource {
    override suspend fun getArticles(): ApiResponse {
        return client.get("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=55a2e462674d42a6864be1fe0e962b9a")
    }
}