package com.mdi.newsapp2.articles.domain

interface UseCase<Input, Output> {
    suspend fun execute(input: Input? = null): Output
}