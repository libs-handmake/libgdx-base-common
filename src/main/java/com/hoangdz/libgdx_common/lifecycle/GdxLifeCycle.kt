package com.hoangdz.libgdx_common.lifecycle

import com.badlogic.gdx.ApplicationListener
import com.hoangdz.libgdx_common.lifecycle.GdxLifeCycleState

/**
 * Created by HoangDepTrai on 17, August, 2022 at 5:08 PM
 */
class GdxLifeCycle : ApplicationListener {

    var state: GdxLifeCycleState? = null

    override fun create() {
        state = GdxLifeCycleState.CREATE
    }

    override fun resize(width: Int, height: Int) {
        state = GdxLifeCycleState.RESIZE
    }

    override fun render() {

    }

    override fun pause() {
        state = GdxLifeCycleState.PAUSE
    }

    override fun resume() {
        state = GdxLifeCycleState.RESUME
    }

    override fun dispose() {
        state = GdxLifeCycleState.DISPOSE
    }

}