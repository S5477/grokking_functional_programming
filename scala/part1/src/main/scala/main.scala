
@main
def main(): Unit = {
    val shoppingCart = ShoppingCart
    val items = List("Book", "Shirt", "Pants")
    val discount = shoppingCart.getDiscountPercentage(items)
    println(s"Discount percentage: $discount%")

    var names: List[String] = List.empty

    println(TipCalculator.getTipPercentage(names))

    names = List("Alice", "Bob", "Charlie")

    println(TipCalculator.getTipPercentage(names))

    names = names ::: List("David", "Eve", "Frank")

    println(TipCalculator.getTipPercentage(names))
}

object ShoppingCart {
    def getDiscountPercentage(items: List[String]): Int = {
        if (items.contains("Book")) {
            5
        } else {
            0
        }
    }
}

object TipCalculator {
    def getTipPercentage(names: List[String]): Int = {
        if (names.length > 5) 20
        else if(names.nonEmpty)  10
        else 0
    }
}