
@main
def main(): Unit = {
    val cities = List("Paris", "Berlin", "London", "Rome", "Madrid")
    println(cumulativeScore(score, cities))

    val numbers = List(5,1,2,4,100)
    println(numbers.foldLeft(0)((acc, number) => acc + number))

    val languages = List("scala", "rust", "ada")
    println(languages.foldLeft(0)((acc, word) => acc + word.length))

    val languages2 = List("scala", "haskell", "rust", "ada")
    println(languages2.foldLeft(0)((acc, word) => acc + word.length - word.replaceAll("s", "").length))

    val numbers2 = List(5,1,2,4,15)
    println(numbers2.foldLeft(Int.MinValue)((max, number) => if(max < number)  number else max))
}


def cumulativeScore(wordScore: String => Int, words: List[String]): Int = {
    words.foldLeft(0)((acc, word) => acc + wordScore(word))
}

def hightScoringWords(wordScore: String => Int): Int => List[String] => List[String] = {
    higherThan => words => words.filter(word => wordScore(word) > higherThan)
}

def wordScores(wordScore: String => Int, words: List[String]): List[Int] = {
    words.map(wordScore)
}

def rankerWords(wordScore: String => Int, words: List[String]): List[String] = {
    words.sortBy(wordScore).reverse
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

def score(word: String): Int = {
    word.replaceAll("a", "").length
}

def bonus(word: String): Int = {
    if (word.contains("c")) 5 else 0
}