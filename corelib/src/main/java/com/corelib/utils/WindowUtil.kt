package com.corelib.utils

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.view.WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
import android.view.WindowManager
import com.corelib.activity.CoreActivity
import kotlin.math.abs


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
            //状态栏透明
            it.statusBarColor = Color.TRANSPARENT
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                it.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                val color = (it.decorView.findViewById<ViewGroup>(android.R.id.content)
                    .getChildAt(0).background as ColorDrawable).color
                if (!isLightColor(abs(color))) {
                    it.decorView.windowInsetsController?.setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS)
                } else {
                    it.decorView.windowInsetsController?.setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS)
                }
            }
        }
    }

    /**
     * 计算颜色
     */
    private fun isLightColor(color : Int) : Boolean{
        // 计算颜色的相对亮度
        val brightness = (299 * Color.red(color) + 587 * Color.green(color) + 114 * Color.blue(color)) / 1000.0;
        // 如果颜色的相对亮度大于等于 128，则认为是浅色
        return brightness >= 128;
    }

}