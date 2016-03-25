package com.EverCraft

/**
 * Created by matthewrighter on 3/25/16.
 */
class Adventurer {
  //Variable Declarations
  private var _name = ""
  private var _alignment: Alignment = Neutral
  private var _hitPoints = 5
  private var _armorClass = 10
  
  //Getters
  def name = _name
  def alignment = _alignment
  def hitPoints = _hitPoints
  def armorClass = _armorClass
  
  //Setters
  def name_= (n: String) = _name = n
  def alignment_= (a: Alignment) = _alignment = a
  def hitPoints_= (hp: Int) = _hitPoints = hp
  def armorClass_= (ac: Int) = _armorClass = ac
}
