package Aquarium

open class Book(val title: String, val author: String) {
    private var currentPage = 0
    open fun readPage() {
        currentPage ++
    }
}

class Ebook(title: String, author: String, var format: String="text"): Book(title, author) {
    private var currentWord = 0
    override fun readPage() {
        currentWord = currentWord + 250
    }
}