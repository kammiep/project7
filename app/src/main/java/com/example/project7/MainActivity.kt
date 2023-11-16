package com.example.project7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import java.io.InputStream
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory

class MainActivity : AppCompatActivity() {
    var balloonsList : ArrayList<Balloon> = ArrayList<Balloon>()
    lateinit var balloons : Balloons
    lateinit var gv:GameView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var factory : SAXParserFactory = SAXParserFactory.newInstance()
        var saxParser : SAXParser = factory.newSAXParser()

        var handler : SAXHandler = SAXHandler()
        var iStream : InputStream = resources.openRawResource( R.raw.balloons1 )

        // start parsing
        saxParser.parse( iStream, handler )

        balloonsList = handler.getBalloons()
        balloons = Balloons(this)
        gv = GameView(balloonsList)
        for (i in balloonsList) {
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