
@main
def main(): Unit = {
    val shoppingCart = ShoppingCart
    val items = List("Book", "Shirt", "Pants")
    val discount = shoppingCart.getDiscountPercentage(items)
    println(s"Discount percentage: $discount%")
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