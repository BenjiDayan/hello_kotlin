import java.lang.Math

fun main(args: Array<String>) {
    println("Hi there, ${args[0]}!")

    eagerExample()
    println(spices_example())
}

fun eagerExample() {
    val decorations = listOf("rock", "pagoda", "platic plant", "alligator")
    val eager = decorations.filter {it[0] =='p'}
    println(eager)

    val filtered = decorations.asSequence().filter { it[0] == 'p'}
    println(filtered)
    println(filtered.toList())

    //val lazyMap = decorations.asSequence

    println("rolling dice: ${rollDice()}, ${rollDice2(3)}")
}

fun spices_example(): List<String> {
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    val sorted = spices.sortedBy {it.length}
    return sorted
}

fun isBigger(s1: String, s2:String): Boolean {
    return s1.length > s2.length
}

fun length(s1: String): Int {
    return s1.length
}

val rollDice = {(Math.random()*12).toInt() + 1}
val rollDice2 = {numSides: Int -> (Math.random()*numSides).toInt() + 1}
