// src/main/scala/example/Currency.scala
package example

import scala.io.Source
import scala.util.{Try, Success, Failure}
import io.circe._
import io.circe.parser._
import io.circe.generic.auto._

case class Currency(CharCode: String, Value: Float)

object Currency {

  def getCurrency(currencyCode: String): Float = {
    val currency = parseCurrency(currencyCode)
    currency.Value
  }

  def parseCurrency(currencyCode: String): Currency = {
    val url = "https://www.cbr-xml-daily.ru/daily_json.js" // URL API

    val response: Try[String] = Try(Source.fromURL(url).mkString)

    response match {
      case Success(data) =>
        val json = parse(data)
        json match {
          case Right(jsonValue) =>
            val currencyOpt = for {
              currency <- jsonValue.hcursor.downField("Valute").downField(currencyCode).as[Currency]
            } yield currency

            currencyOpt match {
              case Right(currency) =>
                return currency
              case Left(error) =>
                return Currency("error", 0)
            }

          case Left(error) =>
                return Currency("error", 0)
        }

      case Failure(exception) =>
                return Currency("error", 0)
    }
  }
}