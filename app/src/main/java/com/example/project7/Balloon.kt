package com.example.project7

class Balloon {
    private var x = 0.0f
    private var y = 0.0f
    private var radius = 0.0f
    constructor(newX:Float,newY:Float,newRadius:Float){
        setX(newX)
        setY(newY)
        setRadius(newRadius)
    }

    fun setX(newX:Float){
        x = newX
    }

    fun setY(newY:Float){
        y = newY
    }

    fun setRadius(newRadius:Float){
        radius = newRadius
    }

    fun getX():Float{
        return x
    }

    fun getY():Float{
        return y
    }

    fun getRadius():Float{
        return radius
    }
}