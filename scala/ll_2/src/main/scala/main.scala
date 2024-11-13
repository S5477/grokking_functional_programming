
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

case class TvShow(title: String, start: Int, end: Int)

def sortShows(shows: List[TvShow]): List[TvShow] = {
  shows.sortBy(TvShow => TvShow.end - TvShow.start).reverse
}

def SortRawShows(rawShows : List[String]) : List[TvShow] = {
  val TvShow = parseShows(rawShows)
  sortShows(TvShow)
}
def parseShows(rawShows: List[String]) : List[TvShow] = {
  rawShows.map(parseShow).flatMap(_.toList)
}

def parseShow(rawShow: String) : Option[TvShow] = {
  for {
    name <- extractName(rawShow)
    yearStart <- extractYearStart(rawShow).orElse(extractSingleYear(rawShow))
    yearEnd <- extractYearEnd(rawShow).orElse(extractSingleYear(rawShow))
  } yield TvShow(name, yearStart, yearEnd)
}

def extractName(raw: String): Option[String] = {
  val breacketOpen = raw.indexOf('(')

  for {
    name <- Some(raw.substring(0, breacketOpen).trim)
  } yield name
}

def extractYearStart(raw: String): Option[Int] = {
  val breacketOpen = raw.indexOf('(')
  val dash = raw.indexOf('-')

  for {
    yearStr <- if(breacketOpen != -1 && dash > breacketOpen + 1)
                  Some(raw.substring(breacketOpen + 1, dash))
                else None
    year <- yearStr.toIntOption
  } yield year
}

def extractYearEnd(raw: String): Option[Int] = {
  val breacketClose = raw.indexOf(')')
  val dash = raw.indexOf('-')

  for {
    yearStr <- if (dash != -1 && dash + 1 < breacketClose)
      Some(raw.substring(dash + 1, breacketClose))
    else None
    year <- yearStr.toIntOption
  } yield year
}

def extractSingleYear(raw: String): Option[Int] = {
  val breacketClose = raw.indexOf(')')
  val breacketOpen = raw.indexOf('(')
  val dash = raw.indexOf('-')

  for {
    yearStr <- if (dash == -1 && breacketOpen != -1 && breacketClose > breacketOpen + 1)
      Some(raw.substring(breacketOpen + 1, breacketClose))
    else None
    year <- yearStr.toIntOption
  } yield year
}
