package example.models.city

object city {
  opaque type City = String

  object City {
    def apply(name: String): City = name
    extension (city: City) def name: String = City()
  }

  case class CityStats(city: City, checkIns: Int)
}
