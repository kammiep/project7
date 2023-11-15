package com.example.project7

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Canvas
import android.view.View

class GameView : View {
    private var bloons:ArrayList<Balloon> = ArrayList<Balloon>()
    private lateinit var paint : Paint
    private lateinit var context : Context

    constructor(context: Context, newBloons:ArrayList<Balloon>) : super(context) {
        bloons = newBloons
        paint = Paint()
        paint.color = Color.CYAN
        paint.isAntiAlias = true
        paint.strokeWidth = 20.0f

        this.context = context
    }

    override fun onDraw(canvas:Canvas){
        super.onDraw(canvas)
        for (bloon in bloons){
            canvas.drawCircle(bloon.getX().toFloat(),bloon.getY().toFloat(),bloon.getRadius().toFloat(),paint)
        }
    }
}