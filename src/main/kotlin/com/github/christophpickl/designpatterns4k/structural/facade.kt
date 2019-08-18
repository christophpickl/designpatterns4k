package com.github.christophpickl.designpatterns4k.structural

// the facade
class MainPanel {
    fun startEngine() {
        println("START engine")
        TurboEngine.fuel()
        TurboEngine.startUp()
        Lights.turnOn()
        HeatingSystem.setDegrees(24)
        println("START engine done")
    }
}

object HeatingSystem {
    fun setDegrees(degrees: Int) {
        println("Now it got $degrees degrees celsuis.")
    }
}

object TurboEngine {
    fun fuel() {
        println("Now 5L gasoline.")
    }
    fun startUp() {
        println("Wrrrooam")
    }
}

object Lights {
    fun turnOn() {
        println("It shall be light!")
    }
}

object FacadeApp {
    @JvmStatic
    fun main(args: Array<String>) {
        MainPanel().startEngine()
    }
}
