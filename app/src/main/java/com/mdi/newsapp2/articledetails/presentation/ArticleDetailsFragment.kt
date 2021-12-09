package com.mdi.newsapp2.articledetails.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import coil.load
import com.mdi.newsapp2.databinding.FragmentArticleDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class ArticleDetailsFragment : Fragment() {

    private val viewModel: ArticleDetailsViewModel by viewModels()

    private val args: ArticleDetailsFragmentArgs by navArgs()

    private var _binding: FragmentArticleDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.setArticleDetails(args.article)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentArticleDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.container.stateFlow.collect { render(it) }
                }
            }
        }
    }

    private fun render(state: ArticleDetailsState) {
        state.article?.let {
            binding.ivImage.load(it.urlToImage)
            binding.tvTitle.text = it.title
            binding.tvContent.text = it.content
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}