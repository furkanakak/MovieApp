package com.furkan.core.common.extension

import java.text.SimpleDateFormat
import java.util.Locale


/**
 * Extension function to extract year from a date string.
 * @return The year extracted from the date string.
 */
fun String.extractYearWithFormatter(): String? {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val date = inputFormat.parse(this)
    val yearFormat = SimpleDateFormat("yyyy", Locale.getDefault())
    return date?.let { yearFormat.format(it) }
}