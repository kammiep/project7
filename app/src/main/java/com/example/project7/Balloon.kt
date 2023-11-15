package com.example.project7

class Balloon {
    private var x = 0
    private var y = 0
    private var radius = 0
    constructor(newX:Int,newY:Int,newRadius:Int){
        setX(newX)
        setY(newY)
        setRadius(newRadius)
    }

    fun setX(newX:Int){
        x = newX
    }

    fun setY(newY:Int){
        y = newY
    }

    fun setRadius(newRadius:Int){
        radius = newRadius
    }

    fun getX():Int{
        return x
    }

    fun getY():Int{
        return y
    }

    fun getRadius():Int{
        return radius
    }
}