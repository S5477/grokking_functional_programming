
@main
def main(): Unit = {
  val xs = List(1)
  val ys = List(-2, 7)
  val zs = List(3,4)

  for {
    x <- xs
    y <- ys
    z <- zs
  } yield Point(x, y, z)

  println(xs.flatMap(x => ys.flatMap(y => zs.map(z => Point(x, y, z)))))
}

case class Point(x: Int, y: Int, z: Int = 0)

def recommendationFlatMap(books: List[Book]): Unit = {
  println(books.flatMap(
    book => book.authors.flatMap(
      author => bookAdaption(author).map(
        movie => s"You may like ${movie.title}, " + s"because you liked $author's ${book.title}"
      )
    )
  ))
}

def recommendationFor(books: List[Book]): Unit = {
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



