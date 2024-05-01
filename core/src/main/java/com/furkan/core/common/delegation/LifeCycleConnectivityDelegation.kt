package com.furkan.core.common.delegation

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Lifecycle

interface LifeCycleConnectivityDelegation {
    fun registerLifeCycleConnectivityDelegation (context: Context, lifecycle: Lifecycle,networkStateChange: (Boolean) -> Unit)
}