package com.furkan.movieapp.ui.detail

import android.os.Bundle
import android.view.View
import com.furkan.core.base.BaseFragment
import com.furkan.core.common.Constants
import com.furkan.movieapp.R
import com.furkan.movieapp.databinding.MovieDetailFragmentBinding

class MovieDetailFragment: BaseFragment<MovieDetailFragmentBinding>(MovieDetailFragmentBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString(Constants.TITLE_ARGUMENT_KEY).run {
            binding.customTopBar.setTitle(this)
        }

    }



}