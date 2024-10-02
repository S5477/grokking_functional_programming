
@main
def main(): Unit = {
  val books = List(
    Book("FP in Scala", List("Chiusano", "Bjarnason")),
    Book("The Hobbit", List("Tolkien"))
  )

  println(books.flatMap(_.authors).flatMap(bookAdaption))
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



