
@main
def main(): Unit = {
    val cities = List("Paris", "Berlin", "London", "Rome", "Madrid")
    def score(word: String): Int = word.replaceAll("a", "").length
    
    println(rankerWords(score, cities))
}

def rankerWords(wordScore: String => Int, words: List[String]): List[String] = {
    words.sortBy(wordScore).reverse
}

def score(word: String): Int = {
    word.replaceAll("a", "").length
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

def replan(plan: List[String], newCity: String, beforeCity: String): List[String] = {
    val beforeIndex = plan.indexOf(beforeCity)

    val citiesBefore = plan.slice(0, beforeIndex)
    val citiesAfter = plan.slice(beforeIndex, plan.size)

    citiesBefore.appended(newCity).appendedAll(citiesAfter)
}

