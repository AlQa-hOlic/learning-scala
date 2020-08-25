package lectures.fp

import scala.util.Try

object Patterns extends App {

  val aNumber = 1

  val patternResult = aNumber match {
    case 0 => "zero"
    case 1 => "one"
    case _ => "don't know"
  }

  println(patternResult)

  // Pattern matching works really well with case classes
  // Normal class need more work to be able to de-structure in a pattern match
  case class Person(name: String, age: Int)

  val me = Person("Rohit", 20)

  val anotherPatternResult = me match {
    case Person(_, a) if a < 10 => s"Hey, can you buy me this toy please?"
    case Person(n, a) => s"Hey, I'm $n and I'm $a years old"
    case _ => s"not a person tho..."
  }

  println(anotherPatternResult)

  println(Try(me match {
    case x if x == null => s"This won't match...throws scala.MatchError"
  }))

  // DON'T DO THIS: overcomplicate with pattern matching
  // val isEven = 4 % 2 == 0
  val isEven = 4 match {
    case n if n % 2 == 0 => true
    case _ => false
  }

}