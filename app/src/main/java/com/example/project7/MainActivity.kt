package com.example.project7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import java.io.InputStream
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory
import android.view.View

class MainActivity : AppCompatActivity(), View.OnTouchListener {
    var balloonsList : ArrayList<Balloon> = ArrayList<Balloon>()
    lateinit var balloons : Balloons
    lateinit var gv:GameView
    //lateinit var detector:GestureDetector
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        var factory : SAXParserFactory = SAXParserFactory.newInstance()
        var saxParser : SAXParser = factory.newSAXParser()

        var handler : SAXHandler = SAXHandler()
        var iStream : InputStream = resources.openRawResource( R.raw.balloons3 )

        //var th : TouchHandler = TouchHandler()
        //detector = GestureDetector(this, th)

        // start parsing
        saxParser.parse( iStream, handler )

        balloonsList = handler.getBalloons()
        balloons = Balloons(this)
        for (i in balloonsList) {
            Log.w("MainActivity",
                i.getX().toString() + "; " + i.getY().toString() + "; " + i.getRadius().toString())
        }
        gv = GameView(this, balloonsList)
        setContentView(gv)
        gv.setOnTouchListener(this)
    }

    /*
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if( event != null )
            detector.onTouchEvent( event )
        return super.onTouchEvent(event)
    }
     */

    override fun onTouch(v: View?, e: MotionEvent?): Boolean {
        if(e != null){
            var clicked = balloons.checkClicked(e.getRawX(), e.getRawY())
            if(!(clicked.getX() == -1f && clicked.getY() == -1f && clicked.getRadius() == 0f)){
                balloonsList.remove(clicked)
                gv.postInvalidate()
            }
        }
        return true
    }
/*
    inner class TouchHandler : GestureDetector.SimpleOnGestureListener() {
        override fun onSingleTapConfirmed(e: MotionEvent):Boolean{
            if(e != null){
                var clicked = balloons.checkClicked(e.getRawX(), e.getRawY())
                if(!(clicked.getX() == -1f && clicked.getY() == -1f && clicked.getRadius() == 0f)){
                    balloonsList.remove(clicked)
                    gv.postInvalidate()
                }
            }
            return true
        }
    }
 */
}