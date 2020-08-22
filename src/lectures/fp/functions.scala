object Functions extends App {

  val doubler = new Function1[Int, Int] {
    override def apply(e: Int): Int = e * 2
  }

  println(doubler(2))

  val doublerLambda: (Int) => Int = (e: Int) => e * 2

  println(doublerLambda(2))

  val superAdder: (Int) => ((Int) => Int) = e => _ + e

  val addThree = superAdder(3)

  println(addThree(3))
  println(addThree(4))


  def curry (x: Int)(y: String) = {
    val repeated = for {
      _ <- 1 to x
    } yield (y)
    repeated.mkString("")
  }

  println(curry(5)("test"))
}
