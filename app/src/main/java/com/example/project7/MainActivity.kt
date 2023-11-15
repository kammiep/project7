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
    lateinit var balloons : Balloons
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var factory : SAXParserFactory = SAXParserFactory.newInstance()
        var saxParser : SAXParser = factory.newSAXParser()

        var handler : SAXHandler = SAXHandler()
        var iStream : InputStream = resources.openRawResource( R.raw.balloons1 )

        // start parsing
        saxParser.parse( iStream, handler )

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