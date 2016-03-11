package com.dj

class Urinal() {
  private var _leftNeighbor: Option[Urinal] = None
  private var _rightNeighbor: Option[Urinal] = None
  private var _position: Int = 0
  private var _status: UrinalStatus = Available

  def leftNeighbor = _leftNeighbor

  def leftNeighbor_=(value: Urinal): Unit = _leftNeighbor = Option(value)

  def rightNeighbor = _rightNeighbor

  def rightNeighbor_=(value: Urinal): Unit = _rightNeighbor = Option(value)

  def position = _position

  def position_=(value: Int): Unit = _position = value

  def status = _status

  def status_=(value: UrinalStatus): Unit = _status = value

  def isAvailable(): Boolean = {
    if (isOccupied(this)) return false

    if (isFirstPositionAndAvailable()) return true

    if (isLastPositionAndAvailable()) return true

    if (isMiddlePositionAndAvailable()) return false

    true
  }

  private def isOccupied(urinal: Urinal): Boolean = {
    urinal.status == Occupied
  }

  def hasLeftNeighbor(): Boolean = {
    _leftNeighbor != None
  }

  def hasRightNeighbor(): Boolean = {
    _rightNeighbor != None
  }

  private def isMiddlePositionAndAvailable(): Boolean = {
    return (hasLeftNeighbor() && isOccupied(leftNeighbor get)) || (hasRightNeighbor() && isOccupied(rightNeighbor get))
  }

  private def isFirstPositionAndAvailable(): Boolean = {
    !hasRightNeighbor() && isUrinalAvailable()
  }

  private def isLastPositionAndAvailable(): Boolean = {
    !hasLeftNeighbor() && isUrinalAvailable()
  }

  private def isUrinalAvailable(): Boolean = {
    status == Available
  }

}
