package com.furkan.core.common.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo

class ConnectivityReceiver(private val listener: ConnectivityChangeListener) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        listener.onNetworkConnectionChanged(isConnected)
    }
}