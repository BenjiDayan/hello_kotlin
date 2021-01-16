package Aquarium

class SimpleSpice {
    var name = "curry"
    var spiciness = "mild"
    var heat = 5
}

class Spice(val name: String, val spiciness: String = "mild") {
    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 3
                "spicy" -> 5
                "very spicy" -> 7
                "extremely spicy" -> 10
                else -> 0
            }
        }


}

fun makeSalt(): Spice {
    return Spice("salt")
}

fun main (args: Array<String>) {
    val spice = SimpleSpice()
    println("spice has spiciness ${spice.spiciness}")

    val mySpices = listOf(Spice("pepper", "mild"),
        Spice("ghost pepper", "extremely spicy"), makeSalt())

    val weakSpices = mySpices.filter {it.heat <= 5}
    println(mySpices)
}