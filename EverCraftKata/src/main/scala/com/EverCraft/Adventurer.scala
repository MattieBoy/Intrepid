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
  private var _attackRoll = 0
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
  def attackRoll = _attackRoll
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
  
  def modifyAttributes = {
    applyConstitutionModifier
    applyDexterityModifier
  }
  
  def applyConstitutionModifier = {
    _hitPoints += _constitution.abilitiesModifiers.getOrElse(_constitution.value, 0)
  }
  
  def applyDexterityModifier = {
    _armorClass += _dexterity.abilitiesModifiers.getOrElse(_dexterity.value, 0)
  }
  
  def randomizedModify(a: Abilities) = {
    a.modifyBy(a.rando(-9 to 10))
  }
  
  def attack(opponent: Adventurer) = {
    strike
    calculateHit(_attackRoll, opponent)
  }

  def strike = {
    val rnd = new Random()
    val range = 1 to 20
    _attackRoll = (rnd.nextInt(range length))
  }

  def modifyAttackRoll = _attackRoll += _strength.abilitiesModifiers.getOrElse(_strength.value, 0)
  
  def calculateHit(s: Int, o: Adventurer) = {
    def didHit: Boolean = s >= o.armorClass
    def wasCritical: Boolean = s == _naturalTwenty
    if (wasCritical) o._hitPoints -= _attackDamage*2 else if (didHit) o._hitPoints -= _attackDamage  //DJ
  }
  
  def isDead: Boolean = {
    this._hitPoints <= 0
  }
  
  def applyModifier(a: Abilities, i: Int) = {
    a.modifyBy(i)
  }
  
  
}
