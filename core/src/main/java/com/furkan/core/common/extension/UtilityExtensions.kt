package com.furkan.core.common.extension

import com.furkan.core.common.Constants
import java.util.Locale


/**
 * Extension function to convert a string to a movie image path.
 * @return The movie image path.
 */
fun String.toMoviePath(): String {
    return Constants.BASE_URL_IMAGE + Constants.IMAGE_SIZE + this
}

/**
 * Extension function to format a double to a single decimal.
 * @return The formatted double.
 */
fun Double?.formatSingleDecimal(): String {
    if (this == null) return "N/A"
    return String.format(Locale.ENGLISH, "%.1f", this)
}

