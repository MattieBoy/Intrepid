package com.EverCraft

/**
 * Created by matthewrighter on 3/25/16.
 */
class Abilities {
  private var _strength = 10
  private var _dexterity = 10
  private var _constitution = 10
  private var _intelligence = 10
  private var _wisdom = 10
  private var _charisma = 10
  
  def strength = _strength
  def dexterity = _dexterity
  def constitution = _constitution
  def intelligence = _intelligence
  def wisdom = _wisdom
  def charisma = _charisma
  
  def strength_= (s: Int) = _strength = s
  def dexterity_= (d: Int) = _dexterity = d
  def constitution_= (c: Int) = _constitution = c
  def intelligence_= (i: Int) = _intelligence = i
  def wisdom_= (w: Int) = _wisdom = w
  def charisma_= (c: Int) = _charisma = c
}
