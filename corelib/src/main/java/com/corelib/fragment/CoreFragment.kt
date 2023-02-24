package com.corelib.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.corelib.activity.CoreActivity

abstract class CoreFragment : Fragment() {

    lateinit var mActivity: CoreActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = requireActivity() as CoreActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initContentView()
        initViewAction()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("fragment","${getFragmentTag()} :onCreateView")
        return onInitView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        Log.d("fragment","${getFragmentTag()} :onResume")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("fragment","${getFragmentTag()} :onDestroy")
        onRelease()
    }

    /**
     * 初始化View
     */
    open fun initContentView() {

    }

    /**
     * 添加View的各种事件
     */
    open fun initViewAction() {

    }

    /**
     * 在onDestroy中手动回收/释放资源
     */
    open fun onRelease() {

    }

    private fun getFragmentTag(): String {
        return this.javaClass.name
    }

    abstract fun onInitView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View


}