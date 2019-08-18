package com.github.christophpickl.designpatterns4k.structural

class MainClass(property: String) {
    private val dataClass = DataClass(property)
    fun doSomething() {
        println("Property: ${dataClass.property}")
    }
}

data class DataClass(
    val property: String
)

object PrivateClassDataApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val mainClass = MainClass("Christoph")
        mainClass.doSomething()
        // mainClass.property
    }
}
