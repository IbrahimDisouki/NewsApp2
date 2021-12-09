package com.mdi.newsapp2.articles.presentation

import androidx.lifecycle.SavedStateHandle
import com.appmattus.kotlinfixture.kotlinFixture
import com.mdi.newsapp2.InstantTaskExecutorExtension
import com.mdi.newsapp2.articles.data.Article
import com.mdi.newsapp2.articles.domain.GetArticlesUseCase
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.orbitmvi.orbit.test

@ExtendWith(InstantTaskExecutorExtension::class)
class ArticlesViewModelTest {
    private val fixture = kotlinFixture()
    private val useCase = mock<GetArticlesUseCase>()

    @Test
    fun `loads articles from server`() = runBlocking {
        val articles = fixture<Pair<List<Article>?, Exception?>>()
        val initialState = ArticlesState()

        whenever(useCase.execute()).thenReturn(articles)

        val viewModel =
            ArticlesViewModel(SavedStateHandle(), useCase).test(initialState = initialState)
        viewModel.runOnCreate()

        viewModel.assert(initialState) {
            states(
                { copy(articles = articles.first, error = articles.second) }
            )
        }
    }

    @Test
    fun `loads articles from server error`() = runBlocking {
        val articles = Pair<List<Article>?, Exception?>(null, Exception())
        val initialState = ArticlesState()

        whenever(useCase.execute()).thenReturn(articles)

        val viewModel =
            ArticlesViewModel(SavedStateHandle(), useCase).test(initialState = initialState)
        viewModel.runOnCreate()

        viewModel.assert(initialState) {
            states(
                { copy(articles = articles.first, error = articles.second) }
            )
        }
    }

    @Test
    fun `navigates to detail screen`() = runBlocking {
        val articles = fixture<Pair<List<Article>, Exception?>>()
        val detailTarget = articles.first.random()
        val initialState = ArticlesState(articles.first, articles.second)

        val viewModel =
            ArticlesViewModel(SavedStateHandle(), useCase).test(initialState = initialState)

        viewModel.testIntent { onArticleClicked(detailTarget) }

        viewModel.assert(initialState) {
            postedSideEffects(ArticlesSideEffect.NavigateToArticleDetails(detailTarget))
        }
    }

}