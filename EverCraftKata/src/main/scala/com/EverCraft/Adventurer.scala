package com.EverCraft

import scala.util.Random

/**
 * Created by matthewrighter on 3/25/16.
 */
class Adventurer{
  //Variable Declarations
  private var _name = ""
  private var _alignment: Alignment = Neutral
  private var _hitPoints = 5
  private var _armorClass = 10
  private val _attackDamage = 1
  private val _naturalTwenty = 20
  
  private val _strength: Abilities = Strength
  private val _constitution: Abilities = Constitution
  private val _dexterity: Abilities = Dexterity
  private val _intelligence: Abilities = Intelligence
  private val _wisdom: Abilities = Wisdom
  private val _charisma: Abilities = Charisma
  
  //Getters
  def name = _name
  def alignment = _alignment
  def hitPoints = _hitPoints
  def armorClass = _armorClass
  def strength = _strength
  def constitution = _constitution
  def dexterity = _dexterity
  def intelligence = _intelligence
  def wisdom = _wisdom
  def charisma = _charisma
  
  //Setters
  def name_= (n: String) = _name = n
  def alignment_= (a: Alignment) = _alignment = a
  def hitPoints_= (hp: Int) = _hitPoints = hp
  def armorClass_= (ac: Int) = _armorClass = ac
  
  var adventurerAbilities: List[Abilities] = List(strength, dexterity, constitution, intelligence, wisdom, charisma)
  
  def setModifiedAbilities(abilities: List[Abilities]) = {
    val c: Abilities => Unit = (x) => randomizedModify(x)
    abilities.map(c)
  }
  
  def randomizedModify(a: Abilities) = {
    a.modifyBy(a.rando(-9 to 10))
  }
  
  def attack(opponent: Adventurer) = {
    val attackRoll = strike
    calculateHit(attackRoll, opponent)
  }
  
  def strike: Int = {
    val rnd = new Random()
    val range = 1 to 20
    range(rnd.nextInt(range length))
  }
  
  def calculateHit(s: Int, o: Adventurer) = {
    def didHit: Boolean = s >= o.armorClass
    def wasCritical: Boolean = s == _naturalTwenty
    if (wasCritical) o.hitPoints -= _attackDamage*2 else if (didHit) o.hitPoints -= _attackDamage
  }
  
  def isDead: Boolean = {
    if (this.hitPoints > 0) false else true
  }
  
  def applyModifier(a: Abilities, i: Int) = {
    a.modifyBy(i)
  }
  
  
}
