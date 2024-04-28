package com.furkan.core.common.costom.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.furkan.core.R
import com.furkan.core.databinding.CustomTopBarBinding

class CustomTopBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding = CustomTopBarBinding.inflate(LayoutInflater.from(context), this, true)
    init {
        context.obtainStyledAttributes(attrs, R.styleable.CustomTopBar).apply {
            val title = getString(R.styleable.CustomTopBar_title)
            recycle()
            setTitle(title)

        }
    }

     fun setTitle(title: String?) {
        binding.titleTextView.text = title
    }



}