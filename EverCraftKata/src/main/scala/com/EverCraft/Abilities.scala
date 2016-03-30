package com.EverCraft

import scala.util.Random

/**
 * Created by matthewrighter on 3/25/16.
 */

trait Abilities {
  def value: Int
  def modifyBy(i: Int)
  def isTooHigh(i: Int): Boolean = i > 20
  def isTooLow(i:Int): Boolean = i < 1
  def rando(r: Range): Int = {
    val rnd = new Random()
    r(rnd.nextInt(r length))
  }

  val abilitiesModifiers = Map(
    1 -> -5,
    2 -> -4,
    3 -> -4,
    4 -> -3,
    5 -> -3,
    6 -> -2,
    7 -> -2,
    8 -> -1,
    9 -> -1,
    10 -> 0,
    11 -> 0,
    12 -> 1,
    13 -> 1,
    14 -> 2,
    15 -> 2,
    16 -> 3,
    17 -> 3,
    18 -> 4,
    19 -> 4,
    20 -> 5)
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




