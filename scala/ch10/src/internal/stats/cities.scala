package example.stats.cities

import example.models.citiy
class cities {
  def topCities(cityCheckIns: Map[City, Int]): List[CityStats] = {
    cityCheckIns.toList.map(
        _ match {
            case (city, checkIns) => CityStats(city, checkIns)
        }
    ).sortBy(_.checkInc).reverse.take(3)
  }

  def proccessCheckIns(checkInc: Stream[IO, City]): IO[Unit] = {
    checkInc.scan(
        Map.empty[City, Int]) ((cityCheckIns, city) =>
            cityCheckIns.updateWith(city) (_.map(_ + 1).orElse(Some(1)))
    ).map(topCities).foreach(IO.println).compile.drain
  }
}
