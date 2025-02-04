package example

object Models {
  enum MusicGenre {
    case Rock
    case Pop
    case HeavyMetal
    case Jazz
    case Classical
    case Country
    case Electronic
    case Folk
    case HipHop
  }

  enum SearchCondition {
    case SearchByGenre(genres: List[MusicGenre])
    case SearchByOrigin(origins: List[Location])
    case SearchByYearsActive(start: Int, end: Int)
  }

  enum YearsActive  {
    case StillActive(start: Int)
    case ActiveBetween(start: Int, end: Int)
  }

  opaque type Location = String
  opaque type Genre = String
  opaque type  YearsActiveStart = Int;

  object Location {
    def apply(value: String) : Location = value
    extension (location: Location) def name: String = location
  }

  case class Artist(
    name: String,
    genre: MusicGenre,
    origin: Location,
    yearsActive: YearsActive
  )

  case class PeriodInYears(start: Int, end: Option[Int])
}
