package com.hoangdz.libgdx_common.components

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Matrix4
import com.hoangdz.libgdx_common.extensions.resetBlendingFunc

/**
 * Created by HoangDepTrai on 15, July, 2022 at 4:40 PM
 */
class GDXDrawingBatchManager {

    private var spriteBatch: SpriteBatch? = null

    private var polygonSpriteBatch: PolygonSpriteBatch? = null

    private var shapeRender: ShapeRenderer? = null

    fun spriteBatch() = kotlin.run {
        return@run spriteBatch ?: SpriteBatch().apply {
            spriteBatch = this
        }
    }

    fun resetBlendingFunc() {
        poly().resetBlendingFunc()
        spriteBatch().resetBlendingFunc()
    }

    fun poly() = kotlin.run {
        polygonSpriteBatch ?: PolygonSpriteBatch().apply {
            polygonSpriteBatch = this
        }
    }

    fun setProjector(matrix4: Matrix4) {
        poly().projectionMatrix = matrix4
        spriteBatch().projectionMatrix = matrix4
        shape().projectionMatrix = matrix4
    }

    fun shape() = kotlin.run {
        shapeRender ?: ShapeRenderer().apply {
            shapeRender = this
        }
    }

    fun glClearColor(color: Color) {
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    fun glClearColor(r: Float, g: Float, b: Float, a: Float) {
        Gdx.gl.glClearColor(r, g, b, a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    fun dispose() {
        spriteBatch?.dispose()
        polygonSpriteBatch?.dispose()
        shapeRender?.dispose()

        spriteBatch = null
        polygonSpriteBatch = null
        shapeRender = null
    }


}