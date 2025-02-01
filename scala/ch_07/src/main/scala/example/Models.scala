package example

object Models {
  opaque type Location = String
  opaque type Genre = String
  opaque type  YearsActiveStart = Int;
  opaque type  YearsActiveEnd = Int;

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

  object YearsActiveEnd {
    def apply(value: Int) : YearsActiveEnd = value
    extension (yearActiveEnd: YearsActiveEnd) def value: Int = yearActiveEnd
  }

  case class Artist(
    name: String,
    genre: Genre,
    origin: Location,
    isActive: Boolean,
    yearActiveStart: YearsActiveStart,
    yearActiveEnd: YearsActiveEnd
  )
}
