package com.github.christophpickl.designpatterns4k.creational

class Singleton private constructor() {
    companion object {
        val instance by lazy { Singleton() }
    }
    init {
        println("Instantiating singleton...")
        Thread.sleep(1_000)
    }
}

object SingletonApp {
    @JvmStatic
    fun main(args: Array<String>) {
        println("singleton 1")
        Singleton.instance
        println("singleton 2")
        Singleton.instance
    }
}
