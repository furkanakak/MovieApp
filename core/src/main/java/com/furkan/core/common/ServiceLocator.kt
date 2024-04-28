package com.furkan.core.common

object ServiceLocator {
    private lateinit var appConfigProvider: AppConfigProvider

    fun registerAppConfigProvider(provider: AppConfigProvider) {
        appConfigProvider = provider
    }

    fun getAppConfig(): AppConfigProvider {
        return appConfigProvider
    }
}