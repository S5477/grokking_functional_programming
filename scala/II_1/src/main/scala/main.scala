
@main
def main(): Unit = {
  for {
    validateName <- validateName("WWII")
    validateStart <- validateStart(1939, 1945)
    validateEnd <- validateEnd(1945)
  } yield println(Event(validateName, validateStart, validateEnd))

  for {
    validateName <- validateName("")
    validateStart <- validateStart(1939, 1945)
    validateEnd <- validateEnd(1945)
  } yield println(Event(validateName, validateStart, validateEnd))

  for {
    validateName <- validateName("WWII")
    validateStart <- validateStart(1955, 1945)
    validateEnd <- validateEnd(1945)
  } yield println(Event(validateName, validateStart, validateEnd))

  for {
    validateName <- validateName("WWII")
    validateStart <- validateStart(1939, 1945)
    validateEnd <- validateEnd(300)
  } yield println(Event(validateName, validateStart, validateEnd))
}

case class Point(x: Int, y: Int)

case class Event(name: String, start: Int, end: Int)

def validateName(name: String): Option[String] = {
  if (name.isEmpty) None else Some(name)
}

def validateStart(start: Int, end: Int): Option[Int] = {
  if (end > start) None else Some(end)
}

def validateEnd(end: Int): Option[Int] = {
  if (end > 2040) None else Some(end)
}

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



