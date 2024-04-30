package com.furkan.core.common.extension

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
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


/**
 * Checks if there is an active internet connection available on the device.
 * This method utilizes the ConnectivityManager to check the network status and
 * its capabilities to determine internet accessibility.
 *
 * @return Returns true if an active network with internet capabilities (Wi-Fi, Cellular, Ethernet) is available.
 * Returns false if there is no active network or the active network does not have internet capabilities.
 */
fun Context.isInternetAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetwork ?: return false
    val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
    return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
}





