package lectures.fp

import scala.util.Random

object Options extends App {
  val myFirstOption = Option(4)
  println(myFirstOption)

  val config: Map[String, String] = Map(
    "host" -> "172.168.1.1",
    "port" -> "80"
  )

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = 
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  class Connection {
    def connect = "Connected"
  }

  // val host = config.get("host")
  // val port = config.get("port")
  // val connection = host.flatMap(h => port.flatMap(p => Connection(h, p)))
  // val connectionStatus = connection.map(c => c.connect)
  // connectionStatus.foreach(println)

  // config.get("host")
  //   .flatMap(host => config.get("port")
  //     .flatMap(port => Connection(host, port))
  //     .map(connection => connection.connect))
  //     .foreach(println)

  // Use for comprehensions for more readable map/flatmap/filter
  
  // Read as...given a host from config,
  // given a port from config &
  // given a connection from Connnection
  // yield connectionStatus

  val connectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect

  connectionStatus.foreach(println)
}