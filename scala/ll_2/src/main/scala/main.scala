
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit = {
  val rawShows = List(
    "Breaking Bad (2008-2013)",
    "The Wire (2002-2008)",
    "Mad Men (2007-2015)"
  )

  println(SortRawShows(rawShows))
}

case class TvShows(title: String, start: Int, end: Int)

def sortShows(shows: List[TvShows]): List[TvShows] = {
  shows.sortBy(tvShows => tvShows.end - tvShows.start).reverse
}

def SortRawShows(rawShows : List[String]) : List[TvShows] = {
  val tvShows = parseShows(rawShows)
  sortShows(tvShows)
}
def parseShows(rawShows: List[String]) : List[TvShows] = {
  rawShows.map(parseShow)
}

def parseShow(rawShow: String) : Option[TvShows] = {
  for {
    name <- extractName(rawShow)
    yearStart <- extractYearStart(rawShow)
    yearEnd <- extractYearEnd(rawShow)
  } yield TvShows(name, yearStart, yearEnd)
  val breacketOpen = rawShow.indexOf('(')
  val breacketClose = rawShow.indexOf(')')
  val dash = rawShow.indexOf('-')
}

def extractName(raw: String): Option[String] = {
  val breacketOpen = rawShow.indexOf('(')

  val yearStrOpt = if (breacketOpen) {
    Some(raw.substring(0, breacketOpen).trim)
  } else None
}

def extractYearStart(raw: String): Option[Int] = {
  val breacketOpen = rawShow.indexOf('(')
  val dash = rawShow.indexOf('-')

  val yearStrOpt = if(breacketOpen != -1 && dash > breacketOpen + 1){
    Some(raw.substring(breacketOpen + 1, dash))
  } else None

  yearStrOpt.map(yeStr => yeStr.toIntOption)
}

def extractYearEnd(raw: String): Option[Int] = {
  val breacketClose = rawShow.indexOf(')')
  val dash = rawShow.indexOf('-')

  val yearStrOpt = if (breacketClose == -1 && dash < breacketOpen + 1) {
    Some(raw.substring(dash + 1, breacketClose))
  } else None

  yearStrOpt.map(yeStr => yeStr.toIntOption)
}
