package com.hoangdz.libgdx_common.utils.listener

import com.badlogic.gdx.InputProcessor

/**
 * Created by HoangDepTrai on 26, December, 2022 at 10:41 AM
 */
open class InputProcessorAdapter : InputProcessor {
    override fun keyDown(keycode: Int): Boolean {
        return false
    }

    override fun keyUp(keycode: Int): Boolean {
        return false
    }

    override fun keyTyped(character: Char): Boolean {
        return false
    }

    override fun touchDown(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchUp(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
       return false
    }

    override fun touchCancelled(screenX: Int, screenY: Int, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun touchDragged(screenX: Int, screenY: Int, pointer: Int): Boolean {
       return false
    }

    override fun mouseMoved(screenX: Int, screenY: Int): Boolean {
       return false
    }

    override fun scrolled(amountX: Float, amountY: Float): Boolean {
       return false
    }
}