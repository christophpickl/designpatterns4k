package com.github.christophpickl.designpatterns4k.creational

interface Builder {
    fun participant(): String
    fun lector(): String
}
class School : Builder {
    override fun participant() = "Jerry Lewis" // different representations
    override fun lector() = "Skinner"
}
class University : Builder{
    override fun participant() = "Will"
    override fun lector() = "Professor"
}

class Parser(private val builder: Builder) {
    fun parse() = "${builder.lector()} is teaching ${builder.participant()}."
}

object BuilderApplication {
    @JvmStatic
    fun main(args: Array<String>) {
//        val parser = Parser(School())
        val parser = Parser(University())

        println(parser.parse())
    }
}
