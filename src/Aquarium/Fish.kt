package Aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {
    val size: Int

    init {
        println("first init block")
    }

    constructor() : this(true, 9) {
        println("running secondary constructor")
    }

    init {
        if (friendly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded * 2
        }
    }

    init {
        println("constructed fish")
    }
}
/*
fun main(args: Array<String>) {
    val myFish = Fish()
    val myFish2 = Fish(false, 15)
    println("fish1 is friendly ${myFish.friendly}, fish2 is friendly ${myFish2.friendly}")
}
*/