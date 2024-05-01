package com.furkan.core.common.delegation

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.furkan.core.common.broadcast.ConnectivityChangeListener
import com.furkan.core.common.broadcast.ConnectivityReceiver

class LifeCycleConnectivityDelegationImpl : LifeCycleConnectivityDelegation,
    DefaultLifecycleObserver,
    ConnectivityChangeListener {
    var networkStateChange: (Boolean) -> Unit = {}
    var context: Context? = null
    private lateinit var connectivityReceiver: ConnectivityReceiver
    override fun registerLifeCycleConnectivityDelegation(
        context: Context,
        lifecycle: Lifecycle,
        networkStateChange: (Boolean) -> Unit
    ) {
        lifecycle.addObserver(this)
        this.networkStateChange = networkStateChange
        this.context = context
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        connectivityReceiver = ConnectivityReceiver(this)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        context?.unregisterReceiver(connectivityReceiver)
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        context?.registerReceiver(connectivityReceiver, intentFilter)
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        networkStateChange(isConnected)
    }
}