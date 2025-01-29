
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit = {
  val rawShows = List(
    "Breaking Bad (2008-2013)",
    "The Wire (2002-2008)",
    "Mad Men (2007-2015)",
    "The Office (2005-2013)",
    "HZ (2005)"
  )

  println(SortRawShows(rawShows))
}

case class TvShow(title: String, start: Int, end: Int)

def sortShows(shows: Either[String, List[TvShow]]): Either[String, List[TvShow]] = {
  shows.map(_.sortBy(TvShow => TvShow.end - TvShow.start).reverse)
}

def SortRawShows(rawShows : List[String]) : Either[String, List[TvShow]] = {
  val TvShow = parseShows(rawShows)
  sortShows(TvShow)
}
def parseShows(rawShows: List[String]) : Either[String, List[TvShow]] = {
  val initialResult : Either[String, List[TvShow]] = Right(List.empty);
  rawShows.map(parseShow).foldLeft(initialResult)(addOrResing)
}

def parseShow(rawShow: String) : Either[String, TvShow] = {
  for {
    name <- extractName(rawShow)
    yearStart <- extractYearStart(rawShow).orElse(extractSingleYear(rawShow))
    yearEnd <- extractYearEnd(rawShow).orElse(extractSingleYear(rawShow))
  } yield TvShow(name, yearStart, yearEnd)
}

def extractName(raw: String): Either[String, String] = {
  val breacketOpen = raw.indexOf('(')

  if (breacketOpen > 0) {
    Right(raw.substring(0, breacketOpen).trim)
  } else {
    Left(s"Can't extract name from $raw")
  }
}

def extractYearStart(raw: String): Either[String, Int] = {
  val breacketOpen = raw.indexOf('(')
  val dash = raw.indexOf('-')

  for {
    yearStr <- if (breacketOpen != -1 && dash > breacketOpen + 1)
      Right(raw.substring(breacketOpen + 1, dash))
    else Left(s"Can't extract start from $raw")
    year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
  } yield year
}

def extractYearEnd(raw: String):Either[String, Int] = {
  val breacketClose = raw.indexOf(')')
  val dash = raw.indexOf('-')

  for {
    yearStr <- if (dash != -1 && breacketClose > dash + 1)
      Right(raw.substring(dash + 1, breacketClose))
    else Left(s"Can't extract end from $raw")
    year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
  } yield year
}

def extractSingleYear(raw: String): Either[String, Int] = {
  val breacketClose = raw.indexOf(')')
  val breacketOpen = raw.indexOf('(')
  val dash = raw.indexOf('-')

  for {
    yearStr <- if (dash == -1 && breacketOpen != -1 && breacketClose > breacketOpen + 1)
      Right(raw.substring(breacketOpen + 1, breacketClose))
    else Left(s"Can't extract single from $raw")
    year <- yearStr.toIntOption.toRight(s"Can't parse $yearStr")
  } yield year
}

def addOrResing(parsedShows: Either[String, List[TvShow]], newParsedShow: Either[String, TvShow]) : Either[String, List[TvShow]] = {
  for {
    shows <- parsedShows
    show <- newParsedShow
  } yield shows.appended(show)
}
