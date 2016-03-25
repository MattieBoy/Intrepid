package com.EverCraft

/**
 * Created by matthewrighter on 3/25/16.
 */
class Adventurer {
  //Variable Declarations
  private var _name = ""
  private var _alignment: Alignment = Neutral
  
  //Getters
  def name = _name
  def alignment = _alignment
  
  //Setters
  def name_= (n: String) = _name = n
  def alignment_= (a: Alignment) = _alignment = a
}
