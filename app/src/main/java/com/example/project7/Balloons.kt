package com.example.project7

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Canvas

class Balloons {
    private lateinit var bloon:Balloon
    private lateinit var paint : Paint

    constructor(newBloon:Balloon){
        bloon = newBloon
        paint = Paint()
        paint.color = Color.CYAN
        paint.isAntiAlias = true
        paint.strokeWidth = 20.0f
    }

    fun buildBloon(){

    }
}