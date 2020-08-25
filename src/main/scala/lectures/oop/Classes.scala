package lectures.oop

object Classes extends App {

  val person = new Person("Rohit", 20)
  println(s"Rohit is ${person.age} years old")

  // Can't do this, because it is not a field just a constructor parameter
  // person.name

  person.greet("xyz")


  val counter = new Counter()
  counter.inc().inc().print()

  counter.inc(10).print()

  // Watch this!

  (counter inc 5).print() // Insanneeeee!!!!!!

  println(counter()) // calling an object as a function is a syntactic sugar for obj.apply()



  class Person(name: String, val age: Int = 0) {

    //def this(name: String) = {
    //  this(name, 0)
    //}

    def greet(name: String) = println(s"${this.name} says: Hi, $name")
  }

  class Counter(val count: Int = 0) {

    // Immutable
    def inc(): Counter = new Counter(this.count + 1)

    def inc(n: Int = 1): Counter = { // Tail recursive function
      if(n <= 0) this
      else inc().inc(n - 1)
    }

    def print() = println(this.count)

    def apply(): String = s"The counter value: ${this.count}"

  }

  // case classes have built in toString, equals & hashcode
  case class Abc(a: Int) {
  }

}