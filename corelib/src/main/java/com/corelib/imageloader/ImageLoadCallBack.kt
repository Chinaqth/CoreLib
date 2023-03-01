package com.corelib.imageloader

interface ImageLoadCallBack {
    fun onLoadSuccess()
    fun onLoadFail()
    fun onLoadStart()
}