
object Expressions extends App {
  // An if statement is an expression
  val test = if (5 > 6) 5 else 6
  // A code block is an expression
  // returns the return value of the last expression
  val aCodeBlock = {
    if (test > 5) "Greater than 5" else "Lesser than or equal to 5"
  }
  // type Unit is a special type that represents void in other languages
  // Typically used as return types for side effects
  val aUnitValue = println(aCodeBlock)
}
