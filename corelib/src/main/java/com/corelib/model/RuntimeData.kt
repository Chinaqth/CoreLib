package com.corelib.model

import android.content.Context
import com.corelib.activity.CoreActivity
import com.corelib.application.CoreApplication
import java.lang.ref.SoftReference

/**
 * # RuntimeData
 * 运行时数据相关
 * @author qth
 */
object RuntimeData {
    private var currentActivityRf: SoftReference<CoreActivity>? = null


    fun setCurrentActivity(coreActivity: CoreActivity?) {
        coreActivity?.let {
            currentActivityRf = SoftReference(coreActivity)
        }
    }

    /**
     * 软引用，获取当前Activity上下文
     */
    fun getCurrentActivity(): CoreActivity? = currentActivityRf?.get()

    fun getApplicationContext(): Context = CoreApplication.appContext
}