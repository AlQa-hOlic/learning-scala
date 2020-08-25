package lectures.fp

import scala.util.Try

object Patterns extends App {

  val aNumber: Any = 1

  val patternResult = aNumber match {
    case 0 => "zero"
    case 1 => "one"
    case x: String => "match by type"
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

  val aStandardList = List(1, 2, 3, 4)
  val listPatternMatching: Unit = aStandardList match {
    case List(1, _, _, _) => // constructor extractor is implemented for List (advanced pattern matching)
    case List(1, _*) => // var args patterns - list of arbitrary length of params
    case 1 :: List(_) => // infix pattern ? don't know what this is...
    case List(1, 2, 3) :+ 42 => // infix pattern
    case List(1, _, _, _) | List(_, _, _, 4) => // starts with 1 or ends with 4
    case List(x, _*) if x == 1 => // if the head is 1 (if guards)
  }

  try {
    // catch blocks are actually pattern matches
  } catch {
    case _: RuntimeException => "runtime"
    case _ => "dunno what error"
  }

  val list = List(1, 2, 3, 4)
  val evenNumbers = for {
    x <- list if x % 2 == 0 // Patterns here toooo!!!
  } yield 10 * x

  val tupleList = List((1, 2), (3, 4))
  val tupleProd = for {
    (x, y) <- tupleList
  } yield x * y

  println(tupleProd)

  // Partial functions are based on pattern match..its like x => x match { //pattern }
  val mappedList = list.map {
    case v if v % 2 == 0 => "is even"
    case _ => "is odd"
  }
  println(mappedList)
}