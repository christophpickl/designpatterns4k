package com.github.christophpickl.designpatterns4k.structural

interface DrawAPI {
    fun drawCircle(position: Int)
}
object RedCircle : DrawAPI {
    override fun drawCircle(position: Int) {
        println("Circle [RED@$position]")
    }
}
object GreenCircle : DrawAPI {
    override fun drawCircle(position: Int) {
        println("Circle [GREEN@$position]")
    }
}

abstract class Shape(protected val drawAPI: DrawAPI) {
    abstract fun draw()
}
class Circle(private val position: Int, drawAPI: DrawAPI) : Shape(drawAPI) {
    override fun draw() {
        drawAPI.drawCircle(position)
    }
}

object BridgeApp {
    @JvmStatic
    fun main(args: Array<String>) {
        Circle(100, RedCircle).draw()
        Circle(412, GreenCircle).draw()
    }
}
