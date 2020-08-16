import java.util.*

fun main(args: Array<String>) {
    var time = args[0].toInt()
    if (time < 12) {
        println("Good morning!")
    }
    if ((time <= 23) and (time >= 12)) {
        println("Good night")
    }

    println("Good ${if (time % 3 == 0) "3 time" else "non 3 time"}")

    feedTheFish()
    /*
    var fortune : String
    for (i in 1..10) {
        fortune = getFortune(getBirthday())
        println("\nYour fortuneis: $fortune")
        if (fortune.contains("Take it easy")) break;
    }
    */
    swim(speed="slow")

    //println("Can add fish?: ${canAddFish(10.5, listOf(1,2,3))}")
    println("Can add fish?: ${canAddFish(10.0, listOf(3,3,3))}")
    println("Can add fish?: ${canAddFish(8.0, listOf(2,2,2), hasDecorations = false)}")
    println("Can add fish?: ${canAddFish(9.0, listOf(1,1,3), 3)}")
    println("Can add fish?: ${canAddFish(10.0, listOf(), 7, true)}")
}

fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
}
fun fishFood(day : String) : String {
    var food = "fasting"
    return when (day) {
        "Mon" -> "flakes"
        "Wed" -> "redworms"
        "Thur" -> "granules"
        "Fri" -> "mosquitoes"
        "Sun" -> "plankton"
        else -> "fasting"
    }

}

fun randomDay() : String{
    val week = listOf("Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun")
    return week[Random().nextInt(7)]
}

fun getBirthday(): Int {
    print("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}

fun getFortune(birthday: Int): String{
    val fortunes = listOf("You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune.")
    return fortunes[birthday.div(fortunes.size) % fortunes.size]
}