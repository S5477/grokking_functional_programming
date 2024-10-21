
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit = {
  val rawShows = List(
    TvShows(title = "Breaking Bad", start = 2008, end = 2013),
    TvShows(title = "The Wire", start = 2002, end = 2008),
    TvShows(title = "Mad Men", start = 2007, end = 2015)
  )

  println(sortShows(rawShows))
}

  case class TvShows(title: String, start: Int, end: Int)

  def sortShows(shows: List[TvShows]): List[TvShows] = {
    shows.sortBy(tvShows => tvShows.end - tvShows.start).reverse
  }
