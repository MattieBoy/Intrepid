package com.mattie

class Restroom(size: Int) {
  var urinals: List[Urinal] = Nil

  for (a <- 1 to size) {
    val uri: Urinal = new Urinal(Available, a)
    urinals = urinals ::: List(uri)
  }

  val outerUrinals = urinals.init zip urinals.tail
  val innerUrinals = urinals.sliding(3).toList

  urinals.foreach { (urinal: Urinal) =>
    if (urinal.rank == 1) {
      urinal.leftNeighbor = null
      urinal.rightNeighbor = outerUrinals.head._2
    } else if (urinal.rank == urinals.size) {
      urinal.leftNeighbor = outerUrinals.last._1
      urinal.rightNeighbor = null
    } else {
      val lila = innerUrinals(urinal.rank - 2)
      urinal.leftNeighbor = lila.head
      urinal.rightNeighbor = lila.last
    }
  }
}
