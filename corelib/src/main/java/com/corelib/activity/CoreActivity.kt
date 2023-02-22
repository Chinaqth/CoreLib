package com.corelib.activity

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.corelib.model.RuntimeData

/**
 * # CoreActivity
 */
open class CoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //记录当前Activity
        RuntimeData.setCurrentActivity(this)
        onCreateContent(savedInstanceState)
        onAfterCreate(savedInstanceState)
    }

    protected fun onCreateContent(savedInstanceState: Bundle?) {

    }

    protected fun onAfterCreate(savedInstanceState: Bundle?) {
        addViewAction(savedInstanceState)
    }

    protected fun addViewAction(savedInstanceState: Bundle?) {

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
    }

}