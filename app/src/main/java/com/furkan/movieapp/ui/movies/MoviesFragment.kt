package com.furkan.movieapp.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.furkan.core.base.BaseFragment
import com.furkan.core.common.networking.Resource
import com.furkan.core.data.entity.Movie
import com.furkan.movieapp.databinding.MoviesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MoviesFragment : BaseFragment<MoviesFragmentBinding>(MoviesFragmentBinding::inflate) {
    private val viewModel: MoviesViewModel by viewModels()
    private val adapter = MovieAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        getMovies()
        observeMovies()
    }

    private fun observeMovies() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.movies.collect { resource ->
                    when (resource.status) {
                        Resource.Status.SUCCESS -> {
                            adapter.setAdapterList(resource.data?.movies ?: emptyList())
                        }

                        Resource.Status.ERROR -> {

                        }

                        Resource.Status.LOADING -> {

                        }
                    }
                }
            }
        }

    }

    private fun setupRecyclerView() {
        binding.rv.adapter = adapter
        adapter.setAdapterItemClickListener(::adapterItemClicked)
    }

    private fun adapterItemClicked(movie: Movie) {
        Log.v("Movie", movie.title ?: "-")
    }

    private fun getMovies() {
        viewModel.getMovies(1)
    }


}