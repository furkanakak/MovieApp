package com.furkan.movieapp.ui.movies

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.furkan.core.base.BaseFragment
import com.furkan.core.common.broadcast.ConnectivityChangeListener
import com.furkan.core.common.broadcast.ConnectivityReceiver
import com.furkan.core.common.extension.isInternetAvailable
import com.furkan.core.common.extension.onScrollToEnd
import com.furkan.core.common.extension.showToast
import com.furkan.core.common.networking.Resource
import com.furkan.core.data.entity.Movie
import com.furkan.movieapp.databinding.MoviesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MoviesFragment : BaseFragment<MoviesFragmentBinding>(MoviesFragmentBinding::inflate),
    ConnectivityChangeListener {
    private val viewModel: MoviesViewModel by viewModels()
    private val adapter = MovieAdapter()
    private lateinit var connectivityReceiver: ConnectivityReceiver
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDefaultNetwork()
        setupRecyclerView()
        observeMovies()
        listener()
    }

    private fun setDefaultNetwork() {
        viewModel.isNetworkAvailable = requireContext().isInternetAvailable()
        viewModel.getMovies()
    }

    private fun listener() {
        binding.customAddButton.setOnClickListener {
            requireContext() showToast "Add Button Clicked"
        }
    }

    private fun observeMovies() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.movies.collect { resource ->
                    when (resource.status) {
                        Resource.Status.SUCCESS -> {
                            adapter.setAdapterList(resource.data?.movies ?: emptyList())
                            binding.progressBar.visibility = View.GONE
                            viewModel.isLoading.value = false
                        }

                        Resource.Status.ERROR -> {
                            binding.progressBar.visibility = View.GONE
                            viewModel.isLoading.value = false
                        }

                        Resource.Status.LOADING -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityReceiver = ConnectivityReceiver(this)
    }

    override fun onPause() {
        super.onPause()
        requireContext().unregisterReceiver(connectivityReceiver)
    }

    override fun onStart() {
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        requireContext().registerReceiver(connectivityReceiver, intentFilter)
        super.onStart()
    }


    private fun setupRecyclerView() {
        binding.rv.adapter = adapter
        adapter.setAdapterItemClickListener(::adapterItemClicked)
        binding.rv.onScrollToEnd(lifecycleScope, viewModel.isLoading) {
            viewModel.getMovies()
        }
    }

    private fun adapterItemClicked(movie: Movie) {
        val action =
            MoviesFragmentDirections.actionMoviesFragmentToMovieDetailFragment(
                movie.title ?: "Movie"
            )
        findNavController().navigate(action)
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        viewModel.isNetworkAvailable = isConnected
    }


}