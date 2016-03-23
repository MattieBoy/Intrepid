package com.mattie

class Urinal(pOccupied: Boolean, pRank: Int) {
  var occupied: Boolean = pOccupied
  var leftNeighbor: Urinal = null
  var rightNeighbor: Urinal = null
  var rank: Int = pRank

  def isOccupied: Boolean = {
    true == occupied
  }
}
