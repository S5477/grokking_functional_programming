package example

case class Artist(
  name: String,
  genre: String,
  origin: String,
  isActive: String,
  yearActiveStart: String,
  yearActiveEnd: String
  )

object Hello extends Greeting with App {
  println(greeting)
}

def searchArtist(
  artists: List[Artist],
  genres: List[String],
  locations: List[String],
  searchByActiveYears: Boolean,
  activeAfter: Int,
  activeBefore: Int
) : List[Artist] = {
  
}

