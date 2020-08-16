package pj_euler

fun main(args: Array<String>) {
    println(digit(1))
    println(digit(10))
    println(digit(100))
    println(digit(1000))
    println(digit(10000))
    println(digit(100000))
    println(digit(1000000))
}

//returns nth digit of 1234567891011121314...
fun digit(n: Int): Char{
    var digitCount = 0
    var i = 1
    while(digitCount < n) {
        val iStr = i.toString()
        if (digitCount + iStr.length < n) {
            digitCount = digitCount + iStr.length
        }
        else {
            return iStr[n-digitCount-1]
        }
        i += 1
    }
    return '*'
}