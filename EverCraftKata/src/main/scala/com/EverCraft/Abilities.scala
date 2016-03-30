package com.EverCraft

/**
 * Created by matthewrighter on 3/25/16.
 */

trait Abilities {
  def value: Int
  def modifyBy(i: Int)
  def isTooHigh(i: Int): Boolean = value + i > 20
  def isTooLow(i:Int): Boolean = value + i < 1
}

case object Strength extends Abilities {
  var value = 10

  def modifyBy(i: Int) = {
    val modified = value + i
    if (isTooHigh(modified)) value = 20 else
    if (isTooLow(modified)) value = 1 else
    value = modified
  }
}
case object Dexterity extends Abilities {
  var value = 10

  def modifyBy(i: Int) = {
    val modified = value + i
    if (isTooHigh(modified)) value = 20 else
    if (isTooLow(modified)) value = 1 else
      value = modified
  }
}
case object Constitution extends Abilities {
  var value = 10

  def modifyBy(i: Int) = {
    val modified = value + i
    if (isTooHigh(modified)) value = 20 else
    if (isTooLow(modified)) value = 1 else
      value = modified
  }
}
case object Intelligence extends Abilities {
  var value = 10

  def modifyBy(i: Int) = {
    val modified = value + i
    if (isTooHigh(modified)) value = 20 else
    if (isTooLow(modified)) value = 1 else
      value = modified
  }
}
case object Wisdom extends Abilities {
  var value = 10

  def modifyBy(i: Int) = {
    val modified = value + i
    if (isTooHigh(modified)) value = 20 else
    if (isTooLow(modified)) value = 1 else
      value = modified
  }
}
case object Charisma extends Abilities {
  var value = 10

  def modifyBy(i: Int) = {
    val modified = value + i
    if (isTooHigh(modified)) value = 20 else
    if (isTooLow(modified)) value = 1 else
      value = modified
  }
}




