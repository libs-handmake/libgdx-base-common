package com.hoangdz.libgdx_common.utils

import android.util.Log
import com.badlogic.gdx.math.Vector2

/**
 * Created by HoangDepTrai on 21, December, 2022 at 1:32 PM
 */
object Calculator {
    //Tìm phương trình đường thẳng qua 2 điểm đã biết a,b. Kết quả trả ra là giá trị a, b, c của pt: ax+by+c =0
    fun equationOfLine(a: Vector2, b: Vector2): FloatArray {
        val n = Vector2(a.y - b.y, b.x - a.x)
        return arrayOf(n.x, n.y, -a.x * n.x - a.y * n.y).toFloatArray()
            .also { Log.e("logErr", "equationOfLine: ${it.contentToString()}") }
    }

    //giai phuong trinh 2 nghiem
    fun findXY2(a: Float, b: Float, c: Float, d: Float, e: Float, f: Float): Vector2? {
        return try {
            var x: Float
            var y: Float
            if (a != 0f) {
                y =
                    ((c * d / a - f) * (a / (e * a - b * d))).takeIf { it.isFinite() } ?: return null
                x = ((-b * y - c) / a).takeIf { it.isFinite() } ?: return null
            } else {
                y =
                    (-c / b).takeIf { it.isFinite() } ?: return null
                x = ((-e * y - f) / d).takeIf { it.isFinite() } ?: return null
            }
            Vector2(x, y).also { Log.e("logErr", "findXY2: $it") }
        } catch (e: Exception) {
            null
        }
    }

    //Tìm giao điểm của 2 đường thẳng biết 2 điểm thuộc đt đó, ab và cd
    fun intersectionOf2Line(a: Vector2, b: Vector2, c: Vector2, d: Vector2): Vector2? {
        val eLine1 = equationOfLine(a, b)
        val eLine2 = equationOfLine(c, d)
        return findXY2(eLine1[0], eLine1[1], eLine1[2], eLine2[0], eLine2[1], eLine2[2])
    }

}