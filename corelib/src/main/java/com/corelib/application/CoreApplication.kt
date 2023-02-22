package com.corelib.application

import android.app.Application
import android.content.Context

/**
 * # CoreApplication
 * appContext 获取当前Application 上下文
 * @author qth
 */
class CoreApplication : Application() {
    companion object {
        lateinit var appContext : Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

}