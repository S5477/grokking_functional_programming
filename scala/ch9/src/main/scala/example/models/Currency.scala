package example.models

object Currency {
  opaque type Currency = String

  object Currency {
    def apply(name: String): Currency = name
    extension(currency: Currency) def name: String = currency
  }
}
