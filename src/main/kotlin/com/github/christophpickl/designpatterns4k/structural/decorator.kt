package com.github.christophpickl.designpatterns4k.structural

interface UiComponent {
    fun draw()
}

class TextField(private val text: String) : UiComponent {
    override fun draw() {
        println("... $text")
    }
}

class InputTextField(private val label: String, private val text: String) : UiComponent {
    override fun draw() {
        println("$label: [[[$text]]]")
    }
}

// the decorator
class TitledHeader(private val label: String, private val child: UiComponent) : UiComponent {
    override fun draw() {
        println("/== $label ==========\\")
        print("    ")
        child.draw()
    }
}

object DecoratorApp {
    @JvmStatic
    fun main(args: Array<String>) {
        TitledHeader("Personal Data", InputTextField("Name", "Christoph")).draw()
        println()
        TitledHeader("Summary", TextField("Well done!")).draw()
    }
}
