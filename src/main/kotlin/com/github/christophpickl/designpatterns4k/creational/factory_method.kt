package com.github.christophpickl.designpatterns4k.creational

import java.math.BigInteger

interface Adder {
    companion object {
        fun factoryMethod(bigNumbers: Boolean) = if(bigNumbers) BigAdder else LilAdder
    }
    fun add(x: Int, y: Int): Int
}

object BigAdder : Adder {
    override fun add(x: Int, y: Int) = (x.toBigInteger() + y.toBigInteger()).toInt()
    private operator fun BigInteger.plus(that: BigInteger) = this.add(that)
}

object LilAdder : Adder {
    override fun add(x: Int, y: Int) = x + y
}

object FactoryMethodApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val adder = Adder.factoryMethod(bigNumbers = true)
        println(adder.add(100_000, 3_000_000))
    }
}
