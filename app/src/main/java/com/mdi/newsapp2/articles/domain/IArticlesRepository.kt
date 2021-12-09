package com.mdi.newsapp2.articles.domain

import com.mdi.newsapp2.articles.data.Article

interface IArticlesRepository {
    suspend fun getArticles(): Pair<List<Article>?, Exception?>
}