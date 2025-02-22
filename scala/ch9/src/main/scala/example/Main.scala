package example

import example.api.CurrencyAPI._
import example.models.Currency

object Main {
  def main(args: Array[String]): Unit = {
    val currency = getCurrencyAPI("USD")
    println(currency)
  }

  def exchangeTable(from: Currency): IO[Map[Currency, Float]]
}