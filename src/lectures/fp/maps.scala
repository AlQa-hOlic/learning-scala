import scala.annotation.tailrec
object Maps extends App {
    // tuples
    val tuple = ("Hello", "world") // new Tuple2("Hello", "world")

    val syntacticSugaredTuple = "Hello" -> "world"

    // maps
    val map = Map(tuple, "This" -> "easy")

    // social network based on scala maps
    def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
        network + (person -> Set())

    def friend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
        val friendsA = network(personA)
        val friendsB = network(personB)

        network + (personA -> (friendsA + personB)) + (personB -> (friendsB + personA))
    }

    def unfriend(network: Map[String, Set[String]], personA: String, personB: String): Map[String, Set[String]] = {
        val friendsA = network(personA)
        val friendsB = network(personB)

        network + (personA -> (friendsA - personB)) + (personB -> (friendsB - personA))
    }

    def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
        @tailrec
        def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
            if(friends.isEmpty) networkAcc
            else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
        }

        val unfriended = removeAux(network(person), network)
        unfriended - person
    }

    // test
    val empty: Map[String, Set[String]] = Map()
    val addPeople = add(add(add(empty, "Rohit"), "BlaBlalaa"), "SomeoneElse");
    val addNetwork = friend(
        friend(
            friend(
                addPeople,
                "Rohit",
                "BlaBlalaa"
            ), 
            "BlaBlalaa",
            "SomeoneElse"
        ),
        "SomeoneElse",
        "Rohit"
    )
    println(addNetwork)
    val removeFriend = unfriend(addNetwork, "Rohit", "SomeoneElse")
    println(removeFriend)

}