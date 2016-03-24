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
    if (isFirstPosition(urinal)) {
      urinal.leftNeighbor = null
      urinal.rightNeighbor = outerUrinals.head._2
    }

    if (isMiddlePosition(urinal)) {
      val lila = innerUrinals(urinal.rank - 2)
      urinal.leftNeighbor = lila.head
      urinal.rightNeighbor = lila.last
    }

    if (isLastPosition(urinal)) {
      urinal.leftNeighbor = outerUrinals.last._1
      urinal.rightNeighbor = null
    }
  }

  def isFirstPosition(u: Urinal): Boolean = {
    1 == u.rank
  }

  def isLastPosition(u: Urinal): Boolean = {
    u.rank == urinals.size
  }

  def isMiddlePosition(u: Urinal): Boolean = {
    u.rank > 1 && u.rank < urinals.size
  }
}
