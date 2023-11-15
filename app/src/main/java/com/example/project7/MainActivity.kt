package com.example.project7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent

class MainActivity : AppCompatActivity() {
    lateinit var balloons : Balloons
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        balloons = Balloons()
        for (i in balloons.getList()) {
            Log.w("MainActivity",
                i.getX().toString() + "; " + i.getY().toString() + "; " + i.getRadius().toString())
        }
    }

    inner class TouchHandler : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapConfirmed(e: MotionEvent):Boolean{
            if(e != null){
                balloons.checkClicked(e.x, e.y)

            }
            return true
        }
    }
}