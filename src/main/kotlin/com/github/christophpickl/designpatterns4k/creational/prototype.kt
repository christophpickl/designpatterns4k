package com.github.christophpickl.designpatterns4k.creational

interface Prototype {
    var count: Int
    fun clone(): Prototype
}

data class PrototypeA(val age: Int, override var count: Int) : Prototype {
    override fun clone() = PrototypeA(age, count)
}

data class PrototypeB(val name: String, override var count: Int) : Prototype {
    override fun clone() = PrototypeB(name, count)
}

object Registry {
    private val prototypeA = PrototypeA(42, 0)
    private val prototypeB = PrototypeB("foobar", 0)
    fun prototype(lookupKey: Int): Prototype {
        val prototype = if (lookupKey < 0) prototypeA else prototypeB
        return prototype.clone()
    }
}

object PrototypeApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val prototype1 = Registry.prototype(-10)
        prototype1.count = 999
        println("prototype1: $prototype1")

        val prototype2 = Registry.prototype(-10)
        println("prototype2: $prototype2") // no effect, count stays 0 not changed to 999
    }
}
