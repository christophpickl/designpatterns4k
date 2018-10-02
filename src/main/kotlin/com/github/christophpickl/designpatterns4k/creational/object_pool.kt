package com.github.christophpickl.designpatterns4k.creational

class CostlyInstance {
    init {
        println("Creating costly instance: $this")
        Thread.sleep(500)
    }
}

object ObjectPool {
    private val pool = mutableListOf<CostlyInstance>()
    fun acquire(): CostlyInstance {
        println("acquire()")
        if (pool.isEmpty()) {
            return CostlyInstance()
        }
        return pool.removeAt(0)
    }
    fun release(instance: CostlyInstance) {
        println("release(instance=$instance)")
        pool += instance
    }
}

object ObjectPoolApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val i1 = ObjectPool.acquire()
        println("i1: $i1")

        val i2 = ObjectPool.acquire()
        println("i2: $i2")

        ObjectPool.release(i1)

        val i3 = ObjectPool.acquire()
        println("i3: $i3")
    }
}
