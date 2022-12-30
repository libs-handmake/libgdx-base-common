package com.hoangdz.libgdx_common.components

import androidx.annotation.CallSuper
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Matrix4
import com.badlogic.gdx.math.Vector3
import com.hoangdz.libgdx_common.lifecycle.GdxLifeCycleApplication
import com.hoangdz.libgdx_common.utils.assets_manager.GdxAssetsManger
import com.hoangdz.libgdx_common.utils.interpolate.SinAxisInterpolate

/**
 * Created by HoangDepTrai on 23, November, 2022 at 9:42 AM
 */
abstract class GdxApp : GdxLifeCycleApplication() {

    val camera by lazy { OrthographicCamera(width, height) }

    val assetsManager by lazy { GdxAssetsManger(this) }

    val drawingBatch by lazy { GDXDrawingBatchManager() }

    val sinInterpolation by lazy { SinAxisInterpolate() }


    open val width
        get() = Gdx.graphics.width * 1f

    open val height
        get() = Gdx.graphics.height * 1f


    open val needToListenResizeChange = true

    override fun resize(width: Int, height: Int) {
        super.resize(width, height)
        if (needToListenResizeChange)
            updateCamera(width * 1f, height * 1f)
    }

    override fun create() {
        super.create()
        updateCamera()
    }

    protected open fun updateCamera(width: Float? = null, height: Float? = null) {
        camera.viewportWidth = width ?: this.width
        camera.viewportHeight = height ?: this.height
        camera.position.set(Vector3(0f, 0f, 0f))
        configCamera(camera.viewportWidth, camera.viewportHeight)
        camera.update()
        updateProjector(camera.combined)
    }

    @CallSuper
    override fun render() {
        super.render()
        sinInterpolation.update()
    }

    protected open fun configCamera(width: Float, height: Float) {

    }

    open fun updateProjector(matrix: Matrix4) {
        drawingBatch.setProjector(matrix)
    }

    override fun dispose() {
        super.dispose()
        sinInterpolation.dispose()
        assetsManager.dispose()
        drawingBatch.dispose()
    }

}