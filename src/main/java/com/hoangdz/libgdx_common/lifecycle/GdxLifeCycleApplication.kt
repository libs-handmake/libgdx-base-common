package com.hoangdz.libgdx_common.lifecycle

import androidx.annotation.CallSuper
import com.badlogic.gdx.ApplicationAdapter
import com.hoangdz.libgdx_common.lifecycle.GdxLifeCycle

/**
 * Created by HoangDepTrai on 17, August, 2022 at 5:04 PM
 */
open class GdxLifeCycleApplication : ApplicationAdapter() {

    val lifecycle by lazy { GdxLifeCycle() }

    @CallSuper
    override fun create() {
        lifecycle.create()
    }

    @CallSuper
    override fun resize(width: Int, height: Int) {
        lifecycle.resize(width, height)
    }

    @CallSuper
    override fun pause() {
        lifecycle.pause()
    }

    @CallSuper
    override fun resume() {
        lifecycle.resume()
    }

    @CallSuper
    override fun dispose() {
        lifecycle.dispose()
    }
}