package com.mattie

object MattieUrinal {

  def main(size: Int): Unit = {
    val restroom: Restroom = new Restroom(size)
    resetRanks(restroom.urinals)
    for (a <- 1 to size) {
      updateRanks(restroom.urinals)
      chooseUrinal(restroom.urinals)
      resetRanks(restroom.urinals)
    }
    updateRanks(restroom.urinals)
  }

  def getMax(urinal1: Urinal, urinal2: Urinal): Urinal = {
    List[Urinal](urinal1, urinal2).sortWith(_.rank < _.rank).last
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
    }
  }

  def resetRanks(urinals: List[Urinal]): List[Urinal] = {
    urinals.map{case (u:Urinal) => (if (!u.isOccupied) u.rank = 0)}
    urinals
  }
}
