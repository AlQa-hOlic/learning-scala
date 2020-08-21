object Inheritance extends App {

  abstract class LivingThing {
    def isLiving = true
    def asString: String
    override def toString(): String = asString
  }

  trait Carnivore extends Herbivore {
    def eat(other: LivingThing): Unit
  }

  trait Herbivore {
    def eat(): Unit
  }

  trait Speech {
    def say(something: String): Unit
  }

  class Person(val name: String) extends LivingThing with Carnivore with Speech {
    def eat() = println(s"$name eats food")
    def eat(other: LivingThing) = println(s"$name eats a $other")
    def say(something: String) = println(s"$name says: $something")
    def asString = s"Person['$name']"
  }

  class Dog extends LivingThing with Carnivore {
    def eat() = println("Bow Bow Bow!!!!!")
    def eat(other: LivingThing) = println("Crunch Crunch...")
    def asString = s"Dog"
  }

  val sorryForHim = new Person("SomeName")
  val scooby = new Dog
  val shaggy = new Person("Shaggy")

  // Some dark story....
  scooby.eat()
  scooby.eat(sorryForHim)
  shaggy.say("What the heck? Bad doggy!")
  shaggy.eat(scooby)
}
