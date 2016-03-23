package com.mattie

class Urinal(_status: UrinalStatus, _rank: Int) {
  var status: UrinalStatus = _status
  var leftNeighbor: Urinal = null
  var rightNeighbor: Urinal = null
  var rank: Int = _rank

  def isOccupied: Boolean = {
    Occupied == status
  }

  def isAvailable: Boolean = {
    Available == status
  }
}
