import java.util.*

fun main(args: Array<String>) {
    println("Hi there!")
    dayOfWeek()
}

fun dayOfWeek() {
    println("What day is it today?")
    var today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    var todayStr: String
    when (today) {
        1 -> todayStr = "Sunday"
        2 -> todayStr = "Monday"
        else -> todayStr = "Some other day"
    }
    println("The day is " + todayStr)
}