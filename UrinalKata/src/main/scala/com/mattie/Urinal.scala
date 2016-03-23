package com.mattie

class Urinal(_status: UrinalStatus, pRank: Int) {
  var status: UrinalStatus = _status
  var leftNeighbor: Urinal = null
  var rightNeighbor: Urinal = null
  var rank: Int = pRank

  def isOccupied: Boolean = {
    Occupied == status
  }

  def isAvailable: Boolean = {
    Available == status
  }
}
