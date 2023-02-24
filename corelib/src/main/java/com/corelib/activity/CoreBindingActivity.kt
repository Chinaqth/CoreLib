package com.corelib.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

open class CoreBindingActivity<V : ViewDataBinding> : CoreActivity() {
    lateinit var mBinding: V

    override fun initLayoutId(): Int {
        return 0
    }

    override fun onCreateContent(savedInstanceState: Bundle?) {
        mBinding = DataBindingUtil.setContentView<V>(this, initLayoutId()).apply {
            lifecycleOwner = this@CoreBindingActivity
        }
    }

    override fun onRelease() {
        super.onRelease()
        mBinding.unbind()
    }

}