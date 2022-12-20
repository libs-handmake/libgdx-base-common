package com.hoangdz.libgdx_common.utils.interpolate

import com.badlogic.gdx.Gdx
import com.hoangdz.libgdx_common.components.ModelComponent
import kotlin.math.sin

/**
 * Created by HoangDepTrai on 20, December, 2022 at 10:10 AM
 */
class SinAxisInterpolate : ModelComponent {

    companion object {

        private const val MIN = (-Math.PI * 2).toFloat()

        private const val MAX = (Math.PI * 2).toFloat()

    }

    private var direction = 1

    private var angle = 0f

    var currentValue = 0f

    override fun update() {
        angle += MAX * Gdx.graphics.deltaTime * direction
        if (angle > MAX) {
            angle = MIN
            direction = 1
        }
        if (angle < MIN) {
            angle = MAX
            direction = -1
        }
        currentValue = sin(angle)
    }

    override fun dispose() {
    }

}