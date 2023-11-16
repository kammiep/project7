package com.example.project7

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Canvas
import kotlin.math.pow
import android.util.Log

class Balloons {
    private var bloonsList: ArrayList<Balloon> = ArrayList<Balloon>()
    private var numBalloons = 0
    private var attempts = 0
    private lateinit var activity : MainActivity
    private var deletedBalloon : Balloon = Balloon(-1f,-1f,0f)


    constructor(activity: MainActivity) {
        bloonsList = activity.balloonsList
        this.activity = activity
        numBalloons = bloonsList.size
    }

    fun checkClicked (x : Float, y : Float) : Balloon {
        Log.w("Ballons", "In checkClicked with x " + x.toString())
        attempts++
        // subtract offset
        var newY : Float = y - 158f
        for (b in bloonsList) {
            // find distance from center
            var d : Double = Math.sqrt((x - b.getX()).pow(2).toDouble() +
                    (newY - b.getY()).pow(2).toDouble())
            Log.w("Balloons", "distance for balloon with x " + b.getX().toString() + " is " + d.toString() + " with radius " + b.getRadius().toString())
            // check if distance is less than radius
            if (d < b.getRadius().toDouble()) {
                return b
            }
        }
        return deletedBalloon
    }

    fun gameWon() : Boolean {
        var maxAttempts = numBalloons + 3
        if (attempts <= maxAttempts && activity.balloonsList.isEmpty()){
            return true
        }
        return false
    }
}