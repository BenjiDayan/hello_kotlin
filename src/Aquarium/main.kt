package Aquarium

fun main (args: Array<String>) {
    buildAquarium()
}
internal fun buildAquarium() {
    val myAquarium = Aquarium()
    println("Length: ${myAquarium.length}; " +
            "Width: ${myAquarium.width} ;" +
            "Height: ${myAquarium.height}.")
    myAquarium.height = 80

    println("New Height: ${myAquarium.height} cm")

    println("Aquarium volume: ${myAquarium.volume}")

    val myAquarium2 = Aquarium(numberOfFish = 15)

    myAquarium2.describeSelf()

    makeFish()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color} \n Plecostomus: ${pleco.color}")
    shark.eat()
    pleco.eat()
}