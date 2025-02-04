package example
import example.Models._
import example.Playlist._

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
  ) : Boolean = {
    artist.yearsActive match {
      case StillActive(start) => start <= yearEnd
      case ActiveBetween(start, end) => start <= yearEnd && end >= yearStart
      case _ => false
    }
  }

  def ActiveLanght(
    artist: Artist,
    currentYear: Int
  ) : Int = {
    artist.yearsActive match {
      case StillActive(start) => currentYear -start
      case ActiveBetween(start, end) => end - start
      case _ => 0
    }
  }

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

  def gatherSongs(playlists: List[Playlist], artist: Artist, genre: MusicGenre) : List[Song] = {
    playlists.flatMap(playlist => {
      playlist.listType match {
        case User(source) => List.empty
        case Artist(source) => if (source == artist) playlist.songs else List.empty
        case Genre(source) => if (source == genre) playlist.songs else List.empty
      }
    })
  }

  def searchArtistByCondition(
    artists: List[Artist],
    requiredConditons: List[SearchCondition]): List[Artist] = {
      requiredConditons.forall(condition =>
        condition match {
          case SearchByGenre(genres) => genres.contains(artist.genre)
          case SearchByOrigin(origins) => origins.contains(artist.origin)
          case SearchByYearsActive(start, end) => wasArtistActive(artist, start, end)
        }
      )
    }
    
}