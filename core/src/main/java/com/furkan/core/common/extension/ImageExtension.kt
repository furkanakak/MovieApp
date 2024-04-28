package com.furkan.core.common.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 * Extension function to load an image into this ImageView using Glide.
 * @param imagePath The path to the image to load.
 */
fun ImageView.loadImage(imagePath: String?) {
    if (!imagePath.isNullOrEmpty()) {
        Glide.with(this.context)
            .load(imagePath)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(20)))
            .into(this)
    }
}