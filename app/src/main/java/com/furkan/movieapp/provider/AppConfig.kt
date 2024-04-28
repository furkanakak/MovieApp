package com.furkan.movieapp.provider

import com.furkan.core.common.AppConfigProvider

import javax.inject.Singleton
import com.furkan.movieapp.BuildConfig

@Singleton
class AppConfig : AppConfigProvider {
    override val isDebug: Boolean = BuildConfig.DEBUG

}