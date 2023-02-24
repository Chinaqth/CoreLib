package com.corelib.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.corelib.model.RuntimeData

/**
 * # CoreActivity
 */
abstract class CoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //记录当前Activity
        RuntimeData.setCurrentActivity(this)
        onCreateContent(savedInstanceState)
        onAfterCreate(savedInstanceState)
    }

    open fun onCreateContent(savedInstanceState: Bundle?) {
        setContentView(initLayoutId())
    }

    open fun onAfterCreate(savedInstanceState: Bundle?) {
        addViewAction(savedInstanceState)
    }

    open fun addViewAction(savedInstanceState: Bundle?) {

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        onRelease()
    }

    /**
     * 在onDestroy中手动回收/释放资源
     */
    open fun onRelease() {

    }

    /**
     * 绑定xml
     */
    @LayoutRes
    abstract fun initLayoutId(): Int

}