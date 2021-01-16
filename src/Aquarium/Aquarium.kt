package Aquarium

import kotlin.math.PI

open class Aquarium (var width: Int = 20, var height: Int = 40, var length: Int = 100) {

    open var volume: Int
        get() = width*height*length / 1000
        set(value) {height = (value * 1000) / (width * length)}

    open var water = volume * 0.9

    constructor(numberOfFish: Int): this() {
        val water = numberOfFish * 2000
        val tank = water /0.9
        height = (tank/ (length * width)).toInt()
    }

    fun describeSelf() {
        println("Aquarium: ${this.volume} liters, ${this.width} x ${this.length} x ${this.height} cm")
    }
}

class TowerTank(): Aquarium() {
    override var water = volume * 0.8
    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }
}