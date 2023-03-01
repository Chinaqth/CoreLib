package com.corelib.imageloader

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.annotation.DrawableRes

interface ImageLoader {
    /**
     * @param imageView target ImageView
     * @param resId resource id
     * @param radius radius of the image
     * @param callBack loading image stats
     */
    fun loadLocalImage(
        imageView: ImageView?, @DrawableRes resId: Int, radius: Int, callBack: ImageLoadCallBack?
    )

    /**
     * @param imageView target ImageView
     * @param url target url
     * @param radius radius of the image
     * @param placeholder default image
     * @param callBack loading image stats
     */
    fun loadUrlImage(
        imageView: ImageView?,
        url: String,
        radius: Int,
        @DrawableRes placeholder: Int,
        callBack: ImageLoadCallBack?
    )

    /**
     * @param imageView target ImageView
     * @param bitmap target bitmap
     * @param radius radius of the image
     * @param callBack loading image stats
     */
    fun loadBitmap(
        imageView: ImageView?, bitmap: Bitmap, radius: Int, callBack: ImageLoadCallBack?
    )
}