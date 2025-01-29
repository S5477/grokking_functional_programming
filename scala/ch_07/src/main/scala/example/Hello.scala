package example

case class Artist(name: String, genre: String, origin: String)

object Hello extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: String = "hello"
}
