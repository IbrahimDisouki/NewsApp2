package com.mdi.newsapp2.articles.data

interface IArticlesRemoteDataSource {
    suspend fun getArticles(): ApiResponse
}