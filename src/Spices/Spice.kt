package Spices
import Aquarium.Color

fun main() {
    val myCurry = Curry("massaman", "hot!!")
    println("the spice is ${myCurry.name}, has color ${myCurry.color}")
    myCurry.grind()

    val idk = SpiceContainer(myCurry)
    println(idk)
    println(idk.label)
}

//abstract class Spice(val name: String, val spiciness: String = "mild") {
//    abstract val heat: Int
//        get() {
//            return when (spiciness) {
//                "mild" -> 1
//                "medium" -> 3
//                "spicy" -> 5
//                "very spicy" -> 7
//                "extremely spicy" -> 10
//                else -> 0
//            }
//        }
//
//
//}

abstract class Spice(val name: String, val spiciness: String = "mild", color: SpiceColor): SpiceColor by color{
    abstract val heat: Int
    abstract fun prepareSpice()
}
class Curry(name:String, spiciness: String, color: SpiceColor = YellowColor):
    Spice(name, spiciness, color), Grinder{
    override val heat = 8
    override fun prepareSpice() {
        println("curry is being ground or something")
    }
}

interface Grinder {
    fun grind(){
        println("grinding myself")
    }
}

interface SpiceColor {
    val color: Color
}

object YellowColor : SpiceColor {
    override val color = Color.YELLOW
}

data class SpiceContainer(val spice: Spice){
    val label = spice.name
}