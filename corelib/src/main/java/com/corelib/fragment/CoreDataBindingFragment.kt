package com.corelib.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class CoreDataBindingFragment<B : ViewDataBinding> : CoreFragment() {
    lateinit var mBinding: B

    override fun onInitView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate<B>(inflater,setContentLayout(),container,false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return mBinding.root
    }

    @LayoutRes
    abstract fun setContentLayout() : Int
}