
@main
def main(): Unit = {
  val books = List(
    Book("FP in Scala", List("Chiusano", "Bjarnason")),
    Book("The Hobbit", List("Tolkien"))
  )

  println(books.flatMap(
    book => book.authors.flatMap(
      author => bookAdaption(author).map(
        movie => s"You may like ${movie.title}, " + s"because you liked $author's ${book.title}"
      )
    )
  ))

  println(for {
    book <- books
    author <- book.authors
    movie <- bookAdaption(author)
  } yield s"You may like ${movie.title}, " + s"because you liked $author's ${book.title}")
}

case class Book(title: String, authors: List[String])
case class Movie(title: String)

def bookAdaption(author: String): List[Movie] = {
  if(author == "Tolkien") {
    List(Movie("An Unexpected Journey"), Movie("The Desolation of Smaug"))
  } else {
    List.empty
  }
}



