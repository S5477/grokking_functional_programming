package example
import example.Models._

object Playlist {
     enum listType{
        case User(source: String)
        case Artist(source: Artist)
        case Genre(source: MusicGenre)
    }

  case class Playlist(
    name: String,
    listType: listType,
    songs: List[Song]
  )

  case class Song(
    name: String,
    artist: Artist
  )
}

