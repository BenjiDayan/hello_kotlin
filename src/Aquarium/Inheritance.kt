package Aquarium

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = Plecostomus2()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction2 {
    fun eat()
}
interface FishColor2 {
    val color: String
}

class Plecostomus2(fishColor: FishColor2=GoldColor): FishAction2 by PrintingFishAction("algae"), FishColor2 by fishColor {
}

object GoldColor: FishColor2 {
    override val color = "gold"
}
object RedColor: FishColor2 {
    override val color = "red"
}

class PrintingFishAction(val food: String): FishAction2 {
    override fun eat() {
        println("eating $food")
    }
}