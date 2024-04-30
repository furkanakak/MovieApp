package com.furkan.core.common.broadcast

interface ConnectivityChangeListener {
    fun onNetworkConnectionChanged(isConnected: Boolean)
}