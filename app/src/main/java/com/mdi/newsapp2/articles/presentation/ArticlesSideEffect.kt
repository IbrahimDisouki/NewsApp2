package com.mdi.newsapp2.articles.presentation

import com.mdi.newsapp2.articles.data.Article

sealed class ArticlesSideEffect {
    data class NavigateToArticleDetails(val article: Article) : ArticlesSideEffect()
}