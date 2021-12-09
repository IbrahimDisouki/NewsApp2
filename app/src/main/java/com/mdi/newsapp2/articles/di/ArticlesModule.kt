package com.mdi.newsapp2.articles.di

import com.mdi.newsapp2.articles.data.ArticlesRemoteDataSource
import com.mdi.newsapp2.articles.data.ArticlesRepository
import com.mdi.newsapp2.articles.data.IArticlesRemoteDataSource
import com.mdi.newsapp2.articles.domain.IArticlesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ArticlesModule {
    @Binds
    abstract fun bindArticlesRemoteDataSource(articlesRemoteDataSource: ArticlesRemoteDataSource): IArticlesRemoteDataSource

    @Binds
    abstract fun bindArticlesRepository(articlesRepository: ArticlesRepository): IArticlesRepository
}