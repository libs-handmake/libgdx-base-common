package com.hoangdz.libgdx_common.lifecycle

import com.hoangdz.libgdx_common.lifecycle.GdxLifeCycleState.*

/**
 * Created by HoangDepTrai on 17, August, 2022 at 5:13 PM
 */

class GdxLiveData<T> {

    companion object {
        val ACCEPTED_STATE = arrayOf(CREATE, PAUSE, RESUME, RESIZE)
    }

    private val lifecycleManager by lazy { mutableListOf<GdxLifeCycle>() }

    private val callbackMap by lazy { hashMapOf<GdxLifeCycle, (T?) -> Unit>() }

    var value: T? = null
        set(value) {
            field = value
            for (lifecycle in lifecycleManager) {
                if (lifecycle.state in ACCEPTED_STATE) {
                    callbackMap[lifecycle]?.invoke(value)
                }
            }
        }

    fun observer(gdxLifeCycle: GdxLifeCycle, onDataChange: (T?) -> Unit) {
        lifecycleManager.add(gdxLifeCycle)
        onDataChange.invoke(value)
        callbackMap[gdxLifeCycle] = onDataChange
    }

    fun observer(app: GdxLifeCycleApplication, onDataChange: (T?) -> Unit) {
        observer(app.lifecycle, onDataChange)
    }
}