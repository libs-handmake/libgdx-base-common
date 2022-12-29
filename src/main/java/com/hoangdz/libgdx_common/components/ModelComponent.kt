package com.hoangdz.libgdx_common.components

import com.badlogic.gdx.math.Vector2

/**
 * Created by HoangDepTrai on 23, November, 2022 at 10:37 AM
 */
interface ModelComponent {

    fun performClickListener(clickPoint:Vector2): Boolean = false

    fun update()

    fun dispose()

}