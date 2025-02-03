package example
import example.Models._
object Hello {
  val artists = List(
    Artist("Doe", HeavyMetal, Location("USA"), StillActive(1980)),
    Artist("Jane Doe", Pop, Location("Canada"), ActiveBetween(1990, 2010)),
    Artist("John", Jazz, Location("USA"), true, ActiveBetween(2000, 2024)),
    Artist("Jane Smith",Classical, Location("Canada"), StillActive(2005))
  )

  def wasArtistActive(
    artist: Artist,
    yearStart: Int,
    yearEnd: Int
  ) : Boolean = ???

  def searchArtist(
  artists: List[Artist],
  genres: List[MusicGenre],
  locations: List[Location],
  searchByActiveYears: Boolean,
  activeAfter: Int,
  activeBefore: Int
  ) : List[Artist] = {
    artists.filter(artist => 
      (genres.isEmpty || genres.contains(artist.genre.name)) &&
      (locations.isEmpty || locations.contains(artist.origin.name)) &&
      (!searchByActiveYears || wasArtistActive(artist.yearsActive, activeAfter, activeBefore)))
  }
}



