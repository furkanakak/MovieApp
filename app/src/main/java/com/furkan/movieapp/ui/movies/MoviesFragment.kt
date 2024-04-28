package com.furkan.movieapp.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.furkan.core.base.BaseFragment
import com.furkan.movieapp.databinding.MoviesFragmentBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MoviesFragment : BaseFragment<MoviesFragmentBinding>(MoviesFragmentBinding::inflate){
    private val viewModel: MoviesViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getMovies()
    }

    private fun getMovies() {
      viewModel.getMovies(1)
    }


}