package com.furkan.core.common.extension

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.furkan.core.common.Constants
import com.furkan.core.common.ServiceLocator
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


/**
 * Extension function to show a toast message.
 * @param message The message to be shown.
 */
infix fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


/**
 * Logs a debug message with the given tag if the application is in debug mode.
 * Usage: "Tag" log "Debug message to log"
 * @param message The message to be logged.
 */
infix fun String.log(message: String) {
    if (ServiceLocator.getAppConfig().isDebug) {
        Log.d(this, message)
    }
}





