package com.dj

class Urinal() {
  private var _position: Int = 0
  private var _status: UrinalStatus = Available

  def isAvailable() = status == Available

  def position = _position
  def position_= (value:Int):Unit = _position = value
  def status = _status
  def status_= (value: UrinalStatus):Unit = _status = value

}
