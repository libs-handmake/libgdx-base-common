package com.hoangdz.libgdx_common.utils.assets_manager

import com.badlogic.gdx.assets.loaders.resolvers.AbsoluteFileHandleResolver
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver
import com.hoangdz.libgdx_common.components.GdxApp

/**
 * Created by HoangDepTrai on 23, November, 2022 at 3:21 PM
 */
class GdxAssetsManger(private val gdx: GdxApp) {

    val internalAssetManager by lazy { SafetyAssetManager(gdx, InternalFileHandleResolver()) }

    val absoluteAssetManager by lazy { SafetyAssetManager(gdx, AbsoluteFileHandleResolver()) }

    fun getAssetManager(external: Boolean = false) =
        if (external) absoluteAssetManager else internalAssetManager

    fun clear() {
        internalAssetManager.clear()
        absoluteAssetManager.clear()
    }

    fun dispose() {
        internalAssetManager.dispose()
        absoluteAssetManager.dispose()
    }

}