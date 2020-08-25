
object Generics extends App {

  class Living
  class Human extends Living
  class Animal extends Living
  class Dog extends Animal
  class Cat extends Animal

  class List[A] // Invariant generic class (accepts values matching a particular type only)
  class CovariantList[+A] // Covariant generic class (accepts values matching the type or its sub-types)
  class ContravariantList[-A] // Contravariant generic class (accepts values matching the type or its super types)

  // bounded types
  class Cage[A <: Animal] // accepts sub-types of Animal, likewise [A >: Animal] accepts super-types of Animal

  class MyList[+A] {
    def add[B >: A](el: B): MyList[B] = new MyList[B] // If a super-type is added to the list, then the resulting list will be of the super-type from then on
  }

  // which means
  val listOfCats = new MyList[Cat]
  val dog = new Dog
  val listOfAnimals: MyList[Animal] = listOfCats.add(dog) // See? this is now a list of animals
  val me = new Human
  val listOfLivingThings: MyList[Living] = listOfAnimals.add(me)
}
