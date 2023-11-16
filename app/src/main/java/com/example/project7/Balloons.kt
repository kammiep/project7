package com.example.project7

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Canvas
import kotlin.math.pow

class Balloons {
    private var bloonsList: ArrayList<Balloon> = ArrayList<Balloon>()
    private var numBalloons = 0
    private var attempts = 0
    private lateinit var activity : MainActivity
    private var deletedBalloon : Balloon = Balloon(-1,-1,0)


    constructor(activity: MainActivity) {
        bloonsList = activity.balloonsList
        this.activity = activity
        numBalloons = bloonsList.size
    }

    fun checkClicked (x : Float, y : Float) : Balloon {
        attempts++
        var ans = false
        for (b in bloonsList) {
            // find distance from center
            var d : Double = Math.sqrt((x - b.getX()).pow(2) +
                    (y - b.getY()).pow(2).toDouble())
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