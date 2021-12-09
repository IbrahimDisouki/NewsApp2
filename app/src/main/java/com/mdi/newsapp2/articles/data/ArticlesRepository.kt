package com.mdi.newsapp2.articles.data

import com.mdi.newsapp2.articles.domain.IArticlesRepository
import javax.inject.Inject

class ArticlesRepository @Inject constructor(
    private val remoteDataSource: IArticlesRemoteDataSource
) : IArticlesRepository {
    override suspend fun getArticles(): Pair<List<Article>?, Exception?> {
        return try {
            Pair(remoteDataSource.getArticles().articles, null)
        } catch (e: Exception) {
            Pair(null, e)
        }
    }
}