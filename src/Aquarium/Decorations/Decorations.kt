package Aquarium.Decorations

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val d1 = Decorations("granite")
    val d2 = Decorations("slate")
    val d3 = Decorations("slate")
    println(d1)
    println(d1.equals(d2))
    println(d2.equals(d3))

    val d4 = d3.copy()
    println(d4)
}

data class Decorations(val rocks: String) {
}

data class Decorations2(val rocks: String, val seaweed: String)