package com.github.christophpickl.designpatterns4k.creational

interface Database
class DevDatabase : Database
class ProdDatabase : Database

interface Network
class DevNetwork : Network
class ProdNetwork : Network

interface Environment { // alias the "abstract factory"
    fun database(): Database
    fun network(): Network
}
class DevEnvironment : Environment {
    override fun database() = DevDatabase()
    override fun network() = DevNetwork()
}
class ProdEnvironment : Environment {
    override fun database() = ProdDatabase()
    override fun network() = ProdNetwork()
}
object CurrentEnvironment {
    val environment: Environment = DevEnvironment()
//    val environment: Environment = ProdEnvironment()
}

class Service(private val database: Database) {
    fun act() {
        println("Using database: ${database.javaClass.name}")
    }
}

object AbstractFactoryApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val service = Service(CurrentEnvironment.environment.database())
        service.act()
    }
}
