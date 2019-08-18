package com.github.christophpickl.designpatterns4k.structural

import com.github.christophpickl.designpatterns4k.structural.AnimalType.DogType

// extrinsic state
enum class Environment {
    Air,
    Water
}

interface Animal {
    fun makeNoise(environment: Environment)
}


class Dog(private val age: Int) : Animal {
    init {
        println("New dog came into existence with age of: $age")
    }
    override fun makeNoise(environment: Environment) {
        if (age > 10) {
            println("Grr....")
            return
        }
        println(when (environment) {
            Environment.Air -> "Bark"
            Environment.Water -> "Blark"
        })
    }
}

enum class AnimalType {
    DogType
}

object AnimalFarm {
    private val cachedDog by lazy { Dog(5) }
    fun takeOne(type: AnimalType): Animal =
        when (type) {
            DogType -> cachedDog
        }
}

object FlyweightApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val environment = Environment.Air

        AnimalFarm.takeOne(DogType).makeNoise(environment)
        AnimalFarm.takeOne(DogType).makeNoise(environment)
    }
}
