package com.example.project7

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Canvas
import android.view.View
import android.util.Log

class GameView : View {
    private var bloons:ArrayList<Balloon> = ArrayList<Balloon>()
    private var paint : Paint
    private var context : Context

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
            Log.w("bloons","Bloon  x : " + bloon.getX() + " bloon y : " + bloon.getY())
            canvas.drawCircle(bloon.getX().toFloat(),bloon.getY().toFloat(),bloon.getRadius().toFloat(),paint)
        }
    }
}