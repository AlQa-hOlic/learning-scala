object StringFunctions extends App {

  val str = "Hello, world!"

  println(str.charAt(0))
  println(str.substring(7, 12))
  println(str.split(' ').toList)
  println(str.replace(", ", " "))
  println(str.toUpperCase)
  println(str.length)

  val name = "Rohit"
  val greeting = s"Hello, ${name + 'i'}....ohh it's $name"
  println(greeting)

  val formattedStr = f"${2.1068f}%2.2f"
  println(formattedStr)

  val noEscapeStr = raw"\n \\See? not escaped"
  println(noEscapeStr)
}
