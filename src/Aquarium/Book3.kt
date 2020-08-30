package Aquarium

fun main(args: Array<String>) {
    println("Hi there!")
    val allBooks = setOf("The Tempest", "Hamlet", "Romeo and Juliet")
    val library = mapOf(allBooks to "William Shakespeare")
    println("Hamlet is in allBooks: ${allBooks.any {it == "Hamlet"}}")

    val moreBooks = library.toMutableMap()
    moreBooks[setOf("The Old man and the sea", "for whom the bell tolls")] = "Ernest Hemingway"
    println(moreBooks)
    println(moreBooks.getOrPut(allBooks, {"AA Milne"}))
    println(moreBooks)
    println(moreBooks.getOrPut(setOf("Winnie the Pooh"), {"AA Milne"}))
    println(moreBooks)
}