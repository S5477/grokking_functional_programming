// src/main/scala/example/Currency.scala
package example.api

import scala.io.Source
import scala.util.{Try, Success, Failure}
import io.circe._
import io.circe.parser._
import io.circe.generic.auto._

case class CurrencyAPI(CharCode: String, Value: Float)

object CurrencyAPI {

  def getCurrencyAPI(currencyCode: String): Float = {
    val currency = parseCurrencyAPI(currencyCode)
    currency.Value
  }

  def parseCurrencyAPI(currencyCode: String): CurrencyAPI = {
    val url = "https://www.cbr-xml-daily.ru/daily_json.js" // URL API

    val response: Try[String] = Try(Source.fromURL(url).mkString)

    response match {
      case Success(data) =>
        val json = parse(data)
        json match {
          case Right(jsonValue) =>
            val currencyOpt = for {
              currency <- jsonValue.hcursor.downField("Valute").downField(currencyCode).as[CurrencyAPI]
            } yield currency

            currencyOpt match {
              case Right(currency) =>
                return currency
              case Left(error) =>
                return CurrencyAPI("error", 0)
            }

          case Left(error) =>
                return CurrencyAPI("error", 0)
        }

      case Failure(exception) =>
                return CurrencyAPI("error", 0)
    }
  }
}