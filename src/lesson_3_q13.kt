fun main(args: Array<String>) {
    var mood = readLine() ?: "happy"
    println(whatShouldIDoToday(mood))
}

fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24): String {
    return when {
        walkToday(mood, weather) -> "Go for a walk"
        bedToday(mood, weather, temperature) -> "stay in bed"
        swimmingToday(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}

fun walkToday(mood:String, weather:String) = mood == "happy" && weather == "Sunny"
fun bedToday(mood:String, weather:String, temperature:Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun swimmingToday(temperature:Int) = temperature > 35