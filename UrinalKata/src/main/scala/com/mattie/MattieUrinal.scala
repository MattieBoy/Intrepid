package com.mattie

import javax.swing.RowFilter.ComparisonType

object MattieUrinal {
  
  def main(size: Int): Unit = {
    val restroom: Restroom = new Restroom(size)
    resetRanks(restroom.urinals)
    for (a <- 1 to size) {
      updateRanks(restroom.urinals)
      chooseUrinal(restroom.urinals)
      resetRanks(restroom.urinals)
      println("-------------------------------------------------")
    }
    updateRanks(restroom.urinals)
  }
  
  def getMax(urinal1: Urinal, urinal2: Urinal): Urinal = {
    List[Urinal](urinal1, urinal2).sortBy(r => (r.rank)).last
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
    def updateUrinalRank: Urinal => Urinal = (u) => calculateRank(u)
    urinals.map(updateUrinalRank)
  }
  
  def calculateRank(urinal: Urinal) = {
    
    if (urinal.occupied == false) {
      if (urinal.leftNeighbor != null) {
        if (urinal.leftNeighbor.occupied) urinal.rank -= 1 else urinal.rank += 1
      }
      if (urinal.rightNeighbor != null) {
        if (urinal.rightNeighbor.occupied) urinal.rank -= 1 else urinal.rank += 1
      }

      if (urinal.rightNeighbor == null) urinal.rank += 1
    }
  urinal
  }

  def resetRanks(urinals: List[Urinal]): List[Urinal] = {
    def resetUrinal: Urinal => Urinal = (x) => reSetIt(x)
    urinals.filter(_.occupied == false).map(resetUrinal)
  }
  
  def reSetIt (u: Urinal): Urinal = {
    u.rank = 0
    u
  }
}

class Restroom(size: Int) {
  var urinals: List[Urinal] = List[Urinal]()

    for (a <- 1 to size) {
      val uri: Urinal = new Urinal(false, a)
      urinals = urinals ::: List(uri)
    }

    val outerUrinals = urinals.init zip urinals.tail
    val innerUrinals = urinals.sliding(3).toList
//    urinals.foreach { (urinal: Urinal) =>
//      if (urinal.rank == 1) { 
//        urinal.leftNeighbor = None
//        urinal.rightNeighbor = outerUrinals.head._2
//      } else if (urinal.rank == urinals.size) { 
//        urinal.leftNeighbor = outerUrinals.last._1
//        urinal.rightNeighbor = None
//      } else {
//        val lila = innerUrinals(urinal.rank - 2)
//        urinal.leftNeighbor = lila.head
//        urinal.rightNeighbor = lila.last
//      }
//    }
  //val statuses = tweets.map(status => if (status.isTruncate) None else Some(status.getText)).flatten
  def outerSetter: (Urinal, Urinal) => Unit = (u1, u2) => setOuterNeighbors((u1, u2))
  outerUrinals.map(outerSetter)

  //urinal is first or last
  def setOuterNeighbors(outer: (Urinal, Urinal)) = {
      outer._1.leftNeighbor = null
      outer._1.rightNeighbor = outer._2
      
      outer._2.leftNeighbor = outer._1
      outer._2.rightNeighbor = null
    }
  
    //urinal is middle
  def setInnerNeighbors(inner: List[Urinal]) = {
      inner(1).leftNeighbor = inner(0)
      inner(1).rightNeighbor = inner(2)
    }
}

class Urinal(pOccupied: Boolean, pRank: Int) {
  var occupied: Boolean = pOccupied
  var leftNeighbor: Urinal = null
  var rightNeighbor: Urinal = null
  var rank: Int = pRank
}