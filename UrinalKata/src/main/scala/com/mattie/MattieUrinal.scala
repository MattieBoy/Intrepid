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

  def whichIsHighestRankedUrinal(u1: Urinal, u2: Urinal): Urinal = {
    List[Urinal](u1, u2).sortWith(_.rank < _.rank).last
  }

  def chooseUrinal(urinals: List[Urinal]): Unit = {
    var max: Urinal = null
    val uris = urinals.filter(_.occupied == false)

    uris.sliding(2).foreach { (list: List[Urinal]) =>
      max = whichIsHighestRankedUrinal(list.head, list.last)
    }
    max.occupied = true
  }

  def updateRanks(urinals: List[Urinal]): List[Urinal] = {
    def updateLeftNeighborRankBasedOnOccupancy(u: Urinal): Unit = {
      if (u.leftNeighbor != null) {
        if (u.leftNeighbor.isOccupied) u.rank -= 1 else u.rank += 1
      }
    }
    def updateRightNeighborRankBasedOnOccupancy(u: Urinal): Unit = {
      if (u.rightNeighbor != null) {
        if (u.rightNeighbor.isOccupied) u.rank -= 1 else u.rank += 1
      }
    }
    def updateRank(u: Urinal): Urinal = {
      updateLeftNeighborRankBasedOnOccupancy(u)
      updateRightNeighborRankBasedOnOccupancy(u)

      if (u.rightNeighbor == null) u.rank += 1
      u
    }

    val update: Urinal => Urinal = (t) => updateRank(t)

    urinals.filter(_.isNotOccupied).map(update)
  }


  def resetRanks(urinals: List[Urinal]): List[Urinal] = {
    urinals.map { case (u: Urinal) => (if (!u.isOccupied) u.rank = 0) }
    urinals
  }
}
