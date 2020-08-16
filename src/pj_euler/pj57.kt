package pj_euler
import kotlin.math.floor
import kotlin.math.sqrt
import kotlin.comparisons.minOf
import kotlin.comparisons.maxOf
import java.math.BigInteger
import kotlin.Boolean
//TODO pj 64
fun main(args: Array<String>) {

    val frac = Fraction(BigInteger.valueOf(6), BigInteger.valueOf(4))
    println(frac)
    frac.reduce()
    println(frac)

    val frac2 = Fraction(BigInteger.valueOf(1),BigInteger.valueOf(3))
    println(frac.add(frac2))

    var idk = CFE(sqrt(2.0))

    idk.convergents.add(1)
    var num = 0
    var outputs = mutableListOf(Fraction(BigInteger.valueOf(1),BigInteger.valueOf(4)))
    for (i in 1..1000) {
        println(i)
        //idk.addNextConvergent() //this is inacurrate
        idk.convergents.add(2)
        val frac = idk.getFrac()
        //println(frac)
        if (frac.top.toString().length > frac.bot.toString().length) {
            num += 1
            outputs.add(frac)
            println("$i frac was up")
        }

    }
    println("Found $num fractions with top more digits than bot")
    println(outputs.subList(0, 9))
    println(outputs.lastIndex)
    println(idk.convergents)

}



class CFE(val target: Double) {
    var theta_i = target
    var convergents: MutableList<Int> = mutableListOf()
    fun addNextConvergent() {
        convergents.add(floor(theta_i).toInt())
        theta_i = 1/(theta_i - convergents.last())
    }

    fun add_many(rep_list: List<Int>, times: Int=1) {
        for (i in 1..times) {
            convergents.addAll(rep_list)
        }
    }

    //Returns the approximation of target given by the convergents
    fun getApproxDouble(): Double {
        var result = convergents.last().toDouble()
        for (conv in convergents.subList(0, convergents.lastIndex).reversed()) {
            result = conv.toDouble() + (1/(result))
        }
        return result
    }

    fun getFrac(): Fraction {
        var result = Fraction(BigInteger(convergents.last().toString()))
        for (conv in convergents.subList(0, convergents.lastIndex).reversed()) {
            result = Fraction(BigInteger(conv.toString())).add(result.flipped())
        }
        return result
    }
}

class Fraction(var top: BigInteger, var bot: BigInteger = BigInteger.ONE) {
    fun add(frac: Fraction): Fraction {
        val topNew = top * frac.bot + bot * frac.top
        val botNew = bot * frac.bot
        val newFrac = Fraction(topNew, botNew)
        newFrac.reduce()
        return newFrac
    }

    fun reduce() {
        val d = hcf(top, bot)
        top = top/d
        bot = bot/d
    }

    fun flipped(): Fraction {
        return Fraction(bot, top)
    }

    override fun toString(): String{
        return "$top/$bot"
    }

}

fun hcf(a: BigInteger, b: BigInteger): BigInteger {
    var a_i = maxOf(a, b)
    var b_i = minOf(a, b)
    while (!b_i.equals(BigInteger.ZERO)) {
        val q = a_i/b_i
        val r = a_i - q * b_i
        a_i = b_i
        b_i = r
    }
    return a_i
}

fun getFracExplicit(cfe: CFE): Fraction {
    var result = Fraction(BigInteger(cfe.convergents.last().toString()))
    println(result)
    val lastIndex = cfe.convergents.lastIndex
    for ((i, conv) in cfe.convergents.subList(0, lastIndex).reversed().withIndex()) {
        println("conv index ${lastIndex-i-1}: $conv + 1/frac = ")
        result = Fraction(BigInteger(conv.toString())).add(result.flipped())
        println(result)
    }
    return result
}