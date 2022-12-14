package com.hoangdz.libgdx_common.utils.assets_manager

import com.badlogic.gdx.assets.AssetDescriptor
import com.badlogic.gdx.assets.AssetLoaderParameters
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.assets.loaders.FileHandleResolver
import com.hoangdz.libgdx_common.components.GdxApp

/**
 * Created by HoangDepTrai on 26, October, 2022 at 3:48 PM
 */
open class SafetyAssetManager : AssetManager {

    private val gdxApp: GdxApp

    private val queueLoading = hashMapOf<String, Boolean>()

    constructor(gdxApp: GdxApp) : super() {
        this.gdxApp = gdxApp
    }

    constructor(gdxApp: GdxApp, resolver: FileHandleResolver?) : super(resolver) {
        this.gdxApp = gdxApp
    }

    constructor(gdxApp: GdxApp, resolver: FileHandleResolver?, defaultLoaders: Boolean) : super(
        resolver,
        defaultLoaders
    ) {
        this.gdxApp = gdxApp
    }


    open fun usage(fileName: String): Int {
        return 0
    }


    fun <T : Any?> loadSafe(fileName: String?, type: Class<T>?) {
        if (isLoadedSafe(fileName) || queueLoading[fileName] == true) return
        try {
            if (!fileName.isNullOrEmpty())
                queueLoading[fileName] = true
            load(fileName, type)
        } catch (e: Exception) {
        }
    }

    fun <T : Any?> loadSafe(
        fileName: String?,
        type: Class<T>?,
        parameter: AssetLoaderParameters<T>?
    ) {
        if (isLoadedSafe(fileName) || queueLoading[fileName] == true) return
        try {
            if (!fileName.isNullOrEmpty())
                queueLoading[fileName] = true
            load(fileName, type, parameter)
        } catch (e: Exception) {
        }
    }

    override fun clear() {
        super.clear()
        queueLoading.clear()
    }

    open fun unloadSafe(fileName: String?) {
        queueLoading.remove(fileName)
        fileName ?: return

        if (usage(fileName) <= 1 && isLoadedSafe(fileName)) {
            try {
                super.unload(fileName)
            } catch (e: Exception) {
            }
        }
    }


    fun updateSafe(): Boolean {
        return try {
            update()
        } catch (e: Exception) {
            true
        }
    }

    fun loadSafe(desc: AssetDescriptor<*>?) {
        try {
            load(desc)
        } catch (e: Exception) {
        }
    }

    inline fun <reified T> getSafe(fileName: String): T? {
        return if (isLoadedSafe(fileName)) get(fileName, T::class.java) else null
    }

    fun isLoadedSafe(fileName: String?): Boolean {
        return try {
            isLoaded(fileName)
        } catch (e: Exception) {
            false
        }
    }
}