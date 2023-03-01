package com.corelib.imageloader

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.annotation.AnimRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.bumptech.glide.request.transition.Transition


object GlideImageLoader : ImageLoader {
    val TAG = "GlideImageLoader"
    override fun loadLocalImage(
        imageView: ImageView?,
        resId: Int,
        radius: Int,
        @AnimRes animId: Int,
        callBack: ImageLoadCallBack?
    ) {
        val factory = DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build()
        imageView?.run {
            Glide.with(context).load(resId).apply {
                if (radius > 0) {
                    apply(RequestOptions().transform(RoundedCorners(radius)))
                }
            }.into(createImageTarget(imageView, animId, callBack))
        }
    }


    override fun loadUrlImage(
        imageView: ImageView?,
        url: String,
        radius: Int,
        placeholder: Int,
        @AnimRes animId: Int,
        callBack: ImageLoadCallBack?
    ) {
        imageView?.run {
            Glide.with(context).load(url).placeholder(placeholder).apply {
                if (radius > 0) {
                    apply(RequestOptions().transform(RoundedCorners(radius)))
                }
            }.transition(withCrossFade(300)).into(createImageTarget(imageView, animId, callBack))
        }
    }

    override fun loadBitmap(
        imageView: ImageView?, bitmap: Bitmap, radius: Int, callBack: ImageLoadCallBack?
    ) {
        imageView?.run {
            Glide.with(context).asBitmap().load(bitmap).apply {
                if (radius > 0) {
                    apply(RequestOptions().transform(RoundedCorners(radius)))
                }
            }.into(createBitmapTarget(imageView, callBack))
        }
    }

    private fun createImageTarget(
        imageView: ImageView?, @AnimRes animId: Int, callBack: ImageLoadCallBack?
    ): CustomTarget<Drawable> {
        return object : CustomTarget<Drawable>() {

            override fun onLoadStarted(placeholder: Drawable?) {
                Log.d(TAG, "onLoadStarted")
                callBack?.onLoadStart()
            }

            override fun onLoadFailed(errorDrawable: Drawable?) {
                Log.d(TAG, "onLoadFailed")
                callBack?.onLoadFail()
            }

            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                Log.d(TAG, "onResourceReady")
                imageView?.run {
                    setImageDrawable(resource)
                    startAnimation(AnimationUtils.loadAnimation(context,animId))
                }
                callBack?.onLoadSuccess()
            }

            override fun onLoadCleared(placeholder: Drawable?) {

            }
        }
    }

    private fun createBitmapTarget(
        imageView: ImageView?, callBack: ImageLoadCallBack?
    ): CustomTarget<Bitmap> {
        return object : CustomTarget<Bitmap>() {

            override fun onLoadStarted(placeholder: Drawable?) {
                super.onLoadStarted(placeholder)
            }

            override fun onLoadFailed(errorDrawable: Drawable?) {
                super.onLoadFailed(errorDrawable)
            }

            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                imageView?.setImageBitmap(resource)
                callBack?.onLoadSuccess()
            }

            override fun onLoadCleared(placeholder: Drawable?) {
            }

        }
    }

}