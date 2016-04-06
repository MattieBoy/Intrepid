package com.EverCraft

/**
 * Created by matthewrighter on 4/5/16.
 */
trait Attributes {
  def value: Int
  def accrue(p: Int)
}

case object ExperiencePoints extends Attributes {
  var value = 0

  def accrue(p: Int) = { value += p }
}

case object Level extends Attributes {
  var value = 1
  
  def accrue(p: Int) = { value += p }
}