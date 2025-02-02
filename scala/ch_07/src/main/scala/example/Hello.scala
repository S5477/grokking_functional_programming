package example
import example.Models._
object Hello {
  val artists = List(
    Artist("John Doe", Genre("Rock"), Location("USA"), true, YearsActiveStart(1980), YearsActiveEnd(2000)),
    Artist("Jane Doe", Genre("Pop"), Location("Canada"), true, YearsActiveStart(1990), YearsActiveEnd(2010)),
    Artist("John Smith", Genre("Rock"), Location("USA"), true, YearsActiveStart(1970), YearsActiveEnd(1990)),
    Artist("Jane Smith", Genre("Pop"), Location("Canada"), true, YearsActiveStart(1980), YearsActiveEnd(2000))
  )

  def searchArtist(
  artists: List[Artist],
  genres: List[Genre],
  locations: List[Location],
  searchByActiveYears: Boolean,
  activeAfter: Int,
  activeBefore: Option[Int]
  ) : List[Artist] = {
    artists.filter(artist => 
      (genres.isEmpty || genres.contains(artist.genre.name)) &&
      (locations.isEmpty || locations.contains(artist.origin.name)) &&
      (!searchByActiveYears ||
      (artist.YearsActiveEnd.forall(_>= activeBefore)) && 
        (artist.yearActiveStart <= activeBefore)))
  }
}



