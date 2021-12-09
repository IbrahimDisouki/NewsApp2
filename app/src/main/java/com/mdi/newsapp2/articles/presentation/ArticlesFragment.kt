package com.mdi.newsapp2.articles.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mdi.newsapp2.databinding.FragmentArticlesBinding
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.viewmodel.observe

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class ArticlesFragment : Fragment() {

    private val viewModel: ArticlesViewModel by viewModels()

    private val articlesAdapter: ArticlesAdapter by lazy {
        ArticlesAdapter {
            viewModel.onArticleClicked(it)
        }
    }

    private var _binding: FragmentArticlesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentArticlesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvArticles.apply {
            setHasFixedSize(true)
            adapter = articlesAdapter
        }

        viewModel.observe(lifecycleOwner = this, state = ::render, sideEffect = ::handleSideEffect)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun render(state: ArticlesState) {
        if (state.articles.isNullOrEmpty()) {
            state.error?.message?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
            articlesAdapter.clearItems()
        } else {
            articlesAdapter.setItems(state.articles)
        }
    }

    private fun handleSideEffect(sideEffect: ArticlesSideEffect) {
        when (sideEffect) {
            is ArticlesSideEffect.NavigateToArticleDetails -> {
                findNavController().navigate(
                    ArticlesFragmentDirections.actionFirstFragmentToSecondFragment(
                        sideEffect.article
                    )
                )
            }
        }
    }

}