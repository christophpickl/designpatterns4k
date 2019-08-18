package com.github.christophpickl.designpatterns4k.structural

import com.github.christophpickl.designpatterns4k.structural.NewInterface.Gender
import com.github.christophpickl.designpatterns4k.structural.NewInterface.Gender.Female
import com.github.christophpickl.designpatterns4k.structural.NewInterface.Gender.Male
import com.github.christophpickl.designpatterns4k.structural.NewInterface.Person

class OldInterface {
    fun greet(salutation: String, name: String) = "Hello $salutation $name!"
}
interface NewInterface {
    fun greet(gender: Gender, person: Person): String
    enum class Gender { Male, Female }
    class Person(val firstName: String, val lastName: String)
}
class Adapter(private val old: OldInterface) : NewInterface {
    override fun greet(gender: Gender, person: Person) = old.greet(
        salutation = when (gender) { Male -> "Mr"; Female -> "Ms"},
        name = person.firstName
    )

}

object AdapterApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val newInterface: NewInterface = Adapter(OldInterface())
        println(newInterface.greet(Gender.Male, Person("Christoph", "Pickl")))
    }
}
