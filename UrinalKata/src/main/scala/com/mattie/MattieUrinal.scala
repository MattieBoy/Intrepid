package com.mattie

object MattieUrinal {

  def main(size: Int): Unit = {
    val restroom: Restroom = new Restroom(size)
    restroom.urinals = resetRanks(restroom.urinals)
    for (a <- 1 to size) {
      restroom.urinals = updateRanks(restroom.urinals)
      chooseUrinal(restroom.urinals)
      restroom.urinals = resetRanks(restroom.urinals)
    }
    restroom.urinals = updateRanks(restroom.urinals)
  }

  def whichIsHighestRankedUrinal(u1: Urinal, u2: Urinal): Urinal = {
    List[Urinal](u1, u2).sortWith(_.rank < _.rank).last
  }

  def chooseUrinal(urinals: List[Urinal]) = {
    urinals.filter(_.status == Available).sortWith(_.rank < _.rank).last.status = Occupied
  }

  def updateRanks(urinals: List[Urinal]): List[Urinal] = {
    def updateRankBasedOnLeftNeighbor(u: Urinal) = {
      if (u.leftNeighbor != null) {
        if (u.leftNeighbor.isOccupied) u.rank -= 1 else u.rank += 1
      }
    }

    def updateRankBasedOnRightNeighbor(u: Urinal) = {
      if (u.rightNeighbor != null) {
        if (u.rightNeighbor.isOccupied) u.rank -= 1 else u.rank += 1
      } else {
       u.rank += 1
      }
    }

    def updateRank(u: Urinal): Urinal = {
      updateRankBasedOnLeftNeighbor(u)
      updateRankBasedOnRightNeighbor(u)
      u
    }

    val update: Urinal => Urinal = (t) => updateRank(t)

    urinals.filter(_.isAvailable).map(update)
  }


  def resetRanks(urinals: List[Urinal]): List[Urinal] = {
    def resetRank(u: Urinal): Urinal = {
      if (u.isAvailable) u.rank = 0
      u
    }

    val reset: Urinal => Urinal = (t) => resetRank(t)
    urinals.map(reset)
  }
}
