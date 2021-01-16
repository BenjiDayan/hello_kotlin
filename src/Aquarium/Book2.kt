package Aquarium

import java.lang.Integer.max
import kotlin.random.Random

fun main(args: Array<String>) {
    val myBook = Book2("Grapes of Wrath", "Mark Twain", "1953")
    println(myBook.getAuthorTitle())
    println(myBook.getAll().toString())
    val (a,b,c) = myBook.getAll()
    println("The book $a was written by $b in year $c")

    val templist = mutableListOf("asdf", "hi there!", "aaaa")
    val allBooks = setOf("The Tempest", "Romeo and Juliet", "The Merchant of Venice", "Hamlet")
    val library = mapOf("Shakespeare" to allBooks)
    println(library.any {it.value.contains("Hamlet")})

    myBook.printURL()
    println("can borrow book?: ${myBook.canBorrow(3)}")

    var puppy = Puppy()
    puppy.playWithBook(myBook)
}

class Book2(val title: String, val author: String, val year: String, var pages: Int = 100) {

    companion object Constants {
        const val BASE_URL = "www.mylibrary.com/books/"
        const val maxNumBooks = 5
    }
    fun getAuthorTitle(): Pair<String, String> {
        return title to author
    }

    fun getAll(): Triple<String, String, String> {
        return Triple(title, author, year)
    }

    fun printURL() {
        println("$BASE_URL$title.html")
    }


    fun canBorrow(num: Int): Boolean {
        return num < maxNumBooks
    }
}

fun Book2.weight() = pages * 1.5
fun Book2.tornPages(num_torn: Int) {
    pages = max(pages - num_torn, 0)
}

class Puppy(){
    fun playWithBook(book: Book2) {
        println("Playing with book ${book.title}")
        val torn_pages = Random.nextInt(10)
        book.tornPages(torn_pages)
        println("Oops tore some pages, ${book.pages} remaining")
    }
}