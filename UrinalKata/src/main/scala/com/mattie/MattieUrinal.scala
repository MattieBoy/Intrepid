package com.mattie

object MattieUrinal {
  
  def main(size: Int): Unit = {
    val restroom: Restroom = new Restroom(size)
    resetRanks(restroom.urinals)
    for (a <- 1 to size) {
      updateRanks(restroom.urinals)
      chooseUrinal(restroom.urinals)
      resetRanks(restroom.urinals)
//      println("-------------------------------------------------")
    }
    updateRanks(restroom.urinals)
  }
  
  def getMax(urinal1: Urinal, urinal2: Urinal): Urinal = {
    if (urinal1.rank > urinal2.rank) urinal1 else urinal2
  }
  
  def chooseUrinal(urinals: List[Urinal]): Unit = {
    var max: Urinal = null
    val uris = urinals.filter(_.occupied == false)

    uris.sliding(2).foreach { (list: List[Urinal]) =>
      max = getMax(list.head, list.last)
    }
    max.occupied = true
  }
  
  def updateRanks(urinals: List[Urinal]) = {
    urinals.foreach { (urinal: Urinal) =>
      if (urinal.occupied == false) {
        if (urinal.leftNeighbor != null) {
          if (urinal.leftNeighbor.occupied) urinal.rank -= 1 else urinal.rank += 1
        }
        if (urinal.rightNeighbor != null) {
          if (urinal.rightNeighbor.occupied) urinal.rank -= 1 else urinal.rank += 1
        }

        if (urinal.rightNeighbor == null) urinal.rank += 1
      }
//      println("urinal is occupied = " + urinal.occupied + " rank = " + urinal.rank)
    }
  }

  def resetRanks(urinals: List[Urinal]): List[Urinal] = {
    urinals.foreach { urinal =>
      if (urinal.occupied == false) urinal.rank = 0
    }
    urinals
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

class Urinal(pOccupied: Boolean, pRank: Int) {
  var occupied: Boolean = pOccupied
  var leftNeighbor: Urinal = null
  var rightNeighbor: Urinal = null
  var rank: Int = pRank
}