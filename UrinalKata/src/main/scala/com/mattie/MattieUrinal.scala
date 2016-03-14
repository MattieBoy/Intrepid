package com.mattie

object MattieUrinal {
  
  def execute(size: Int): Unit = {
    val restroom: Restroom = new Restroom(size)
    for (a <- 1 to size) {

      chooseUrinal(restroom)
      resetRanks(restroom)
    }
  }
  
  def chooseUrinal(restroom: Restroom): Unit = {
    
  }

  def resetRanks(restroom: Restroom): Restroom = {
    restroom.urinals.foreach { urinal =>
      if (urinal.occupied == false) urinal.rank = 0
    }

    restroom
  }

}

class Restroom(size: Int) {
  var urinals: List[Urinal] = Nil

    for (a <- 1 to size) {
      val uri: Urinal = new Urinal(false, a)
      urinals = urinals ::: List(uri)
    }

    val outerUrinals = urinals.init zip urinals.tail
    val innerUrinals = urinals.sliding(3).toList
  
    urinals.foreach { (urinal: Urinal) =>
      if (urinal.rank == 1) { 
        urinal.leftNeighbor = null
        urinal.rightNeighbor = Some(outerUrinals.head._2)
      } else if (urinal.rank == urinals.size) { 
        urinal.leftNeighbor = Some(outerUrinals.last._1)
        urinal.rightNeighbor = null
      } else {
        val lila = innerUrinals(urinal.rank - 2)
        urinal.leftNeighbor = Some(lila.head)
        urinal.rightNeighbor = Some(lila.last)
      }
    }
}

class Urinal(pOccupied: Boolean, pRank: Int) {
  var occupied: Boolean = pOccupied
  var leftNeighbor = None: Option[Urinal]
  var rightNeighbor = None: Option[Urinal]
  var rank: Int = pRank
}