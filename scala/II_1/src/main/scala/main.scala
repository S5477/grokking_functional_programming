
@main
def main(): Unit = {
  val books = List(
    Book("FP in Scala", List("Chiusano", "Bjarnason")),
    Book("The Hobbit", List("Tolkien"))
  )

  println(books.map(_.authors).flatten)
}

case class  Book(title: String, authors: List[String])






