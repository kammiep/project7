package com.example.project7

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Canvas
import kotlin.math.pow

class Balloons {
    private var bloonsList: ArrayList<Balloon> = ArrayList<Balloon>()
    private lateinit var handler : SAXHandler

    constructor() {
        handler = SAXHandler()
        bloonsList = handler.getBalloons()

    }

    fun checkClicked (x : Float, y : Float) : Boolean {
        var ans = false
        for (b in bloonsList) {
            // find distance from center
            var d : Double = Math.sqrt((x - b.getX()).pow(2) +
                    (y - b.getY()).pow(2).toDouble())
            // check if distance is less than radius
            if (d < b.getRadius().toDouble()) {
                ans = true
            }
        }
        return ans
    }

    fun getList() : ArrayList<Balloon> {
        return bloonsList
    }
}