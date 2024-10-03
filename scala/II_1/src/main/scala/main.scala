
@main
def main(): Unit = {
  val points = List(Point(5 ,2), Point(1, 1))
  val radiuses = List(2, 1)

  for {
    radius <- radiuses
    point <- points.filter(p => isInside(p, radius))
  } yield println(point)

  for {
    radius <- radiuses
    point <- points
    if isInside(point, radius)
  } yield println(point)
  
  
}

case class Point(x: Int, y: Int)


def isInside(pint: Point, radius: Int): Boolean = {
  radius * radius >= pint.x * pint.x + pint.y * pint.y
}

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



