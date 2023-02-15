package com.corelib.utils

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import com.corelib.activity.CoreActivity

/**
 *  # WindowUtil
 *  调整屏幕状态栏导航栏状态相关
 */
object WindowUtil {

    /**
     * 透明状态栏
     */
    fun  statusBarTransparent(activity: CoreActivity) {
        activity.window.statusBarColor = Color.TRANSPARENT
    }

    /**
     * 显示状态栏
     */
    fun showStatusBars(activity: CoreActivity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.window.decorView.windowInsetsController?.show(WindowInsets.Type.statusBars())
        }
    }
    /**
     * 隐藏状态栏
     */
    fun hideStatusBars(activity: CoreActivity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.window.decorView.windowInsetsController?.hide(WindowInsets.Type.statusBars())
        }
    }
    /**
     * 显示导航
     */
    fun showNavigationBars(activity: CoreActivity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.window.decorView.windowInsetsController?.show(WindowInsets.Type.navigationBars())
        }
    }

    /**
     * 隐藏导航栏
     */
    fun hideNavigationBars(activity: CoreActivity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.window.decorView.windowInsetsController?.hide(WindowInsets.Type.navigationBars())
        }
    }

    /**
     * 反色
     */
    fun statusBarsLightMod(activity: CoreActivity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.window.decorView.windowInsetsController?.setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS)
        }
    }

    /**
     * 同色
     */
    fun statusBarsNormalMod(activity: CoreActivity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.window.decorView.windowInsetsController?.setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS)
        }
    }

    /**
     * 全屏
     */
    fun fullScreenMode(activity: CoreActivity) {
        activity.window.let {
            it.statusBarColor = Color.TRANSPARENT
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                it.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                it.decorView.windowInsetsController?.setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS)
            }
        }
    }

}