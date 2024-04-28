package com.furkan.movieapp.application

import dagger.hilt.android.HiltAndroidApp
import android.app.Application
import com.furkan.core.common.ServiceLocator
import com.furkan.movieapp.provider.AppConfig

@HiltAndroidApp
class Application : Application(){
    override fun onCreate() {
        super.onCreate()
        ServiceLocator.registerAppConfigProvider(AppConfig())
    }
}