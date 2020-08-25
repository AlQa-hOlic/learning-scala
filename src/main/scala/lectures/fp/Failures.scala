package lectures.fp

import scala.util.{Success,Failure,Try}

object Failures extends App {
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("such a failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("No string for you!!!!")

  val potentialFail = Try(unsafeMethod())
  println(potentialFail)

  // syntactic suger
  val someOtherFailure = Try {
    //code that might throw exception
  }

  println(potentialFail.isSuccess)

  def backupMethod(): String = "Success!!!!"
  val fallback = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallback)
}