package com.dj

class Urinal() {
  def getScore():Int = {
    if (_leftNeighbor != None && _rightNeighbor != None) return 1
    0
  }

  private var _leftNeighbor = None : Option[Urinal]
  private var _rightNeighbor = None : Option[Urinal]
  private var _position: Int = 0
  private var _status: UrinalStatus = Available

  def hasLeftNeighbor() = _leftNeighbor != None
  def hasRightNeighbor() = _rightNeighbor != None
  def isAvailable() = status == Available

  def leftNeighbor = _leftNeighbor
  def leftNeighbor_= (value:Urinal):Unit = _leftNeighbor = Option(value)
  def rightNeighbor = _rightNeighbor
  def rightNeighbor_= (value:Urinal):Unit = _rightNeighbor = Option(value)
  def position = _position
  def position_= (value:Int):Unit = _position = value
  def status = _status
  def status_= (value: UrinalStatus):Unit = _status = value

}
