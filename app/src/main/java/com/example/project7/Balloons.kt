package com.example.project7

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Canvas

class Balloons {
    private var bloonsList: ArrayList<Balloon> = ArrayList<Balloon>()
    private lateinit var handler : SAXHandler

    constructor() {
        bloonsList = handler.getBalloons()

    }

    fun buildBloon(){

    }

    fun checkClicked (x : Float, y : Float) : Boolean {
        return false
    }

    fun getList() : ArrayList<Balloon> {
        return bloonsList
    }
}