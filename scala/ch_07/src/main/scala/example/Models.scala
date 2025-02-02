package example

object Models {
  opaque type Location = String
  opaque type Genre = String
  opaque type  YearsActiveStart = Int;

  object Location {
    def apply(value: String) : Location = value
    extension (location: Location) def name: String = location
  }

  object Genre {
    def apply(value: String) : Genre = value
    extension (genre: Genre) def name: String = genre
  }

  object YearsActiveStart {
    def apply(value: Int) : YearsActiveStart = value
    extension (yearActiveStart: YearsActiveStart) def value: Int = yearActiveStart
  }

  case class Artist(
    name: String,
    genre: Genre,
    origin: Location,
    isActive: Boolean,
    yearActiveStart: YearsActiveStart,
    yearActiveEnd: Option[Int]
  )
}
