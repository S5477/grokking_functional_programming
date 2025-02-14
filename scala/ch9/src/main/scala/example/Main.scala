package example

import Currency._

object Main {
  def main(args: Array[String]): Unit = {
    val currency = getCurrency("USD")
    println(currency)
  }
}