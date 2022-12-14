package com.hoangdz.libgdx_common.utils.listener

import androidx.annotation.CallSuper
import com.badlogic.gdx.input.GestureDetector
import com.badlogic.gdx.math.Vector2

abstract class GestureDetectorAdapter : GestureDetector.GestureListener {

//    private val initialPointer1 by lazy { Vector2(0f, 0f) }
//
//    var touchThreshold = 0f
//
//    private var lastTouchDistance = 0f
//
//    private val initialPointer2 by lazy { Vector2(0f, 0f) }

    override fun touchDown(x: Float, y: Float, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun tap(x: Float, y: Float, count: Int, button: Int): Boolean {
        return false
    }

    override fun longPress(x: Float, y: Float): Boolean {
        return false
    }

    override fun fling(velocityX: Float, velocityY: Float, button: Int): Boolean {
        return false
    }

    override fun pan(x: Float, y: Float, deltaX: Float, deltaY: Float): Boolean {
        return false
    }

    override fun panStop(x: Float, y: Float, pointer: Int, button: Int): Boolean {
        return false
    }

    override fun zoom(initialDistance: Float, distance: Float): Boolean {
        return false
    }

    @CallSuper
    override fun pinch(
        initialPointer1: Vector2?,
        initialPointer2: Vector2?,
        pointer1: Vector2?,
        pointer2: Vector2?
    ): Boolean {
//        if (initialPointer2?.isSamePoint(this.initialPointer2) == true && initialPointer1?.isSamePoint(
//                this.initialPointer1
//            ) == true
//        ) {
//            val currentTouchVector = (pointer1 ?: return true) vectorWith (pointer2 ?: return true)
//            touchThreshold = currentTouchVector.getDistance() - lastTouchDistance
//            lastTouchDistance = currentTouchVector.getDistance()
//        } else {
//            touchThreshold = 0f
//            lastTouchDistance =
//                ((pointer1 ?: return true) vectorWith (pointer2 ?: return true)).getDistance()
//        }
//        this.initialPointer1.apply {
//            x = initialPointer1?.x ?: 0f
//            y = initialPointer1?.y ?: 0f
//        }
//        this.initialPointer2.apply {
//            x = initialPointer2?.x ?: 0f
//            y = initialPointer2?.y ?: 0f
//        }
        return false
    }

    override fun pinchStop() {
    }
}