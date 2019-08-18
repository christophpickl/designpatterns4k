package com.github.christophpickl.designpatterns4k.structural

interface Element {
    fun print()
}

class Leaf(private val label: String) : Element {
    override fun print() {
        println(label)
    }
}

class Node(private val label: String, private val elements: List<Element>) : Element {
    override fun print() {
        println(label)
        elements.forEach { it.print() }
    }

}

object CompositeApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val root: Element = Node("root", listOf(
            Leaf("left1"), Node("mother", listOf(Leaf("right1"), Leaf("right2")))
        ))
        root.print()
    }
}
