package com.EverCraft

/**
 * Created by matthewrighter on 3/25/16.
 */
class Adventurer{
  //Variable Declarations
  private var _name = ""
  private var _alignment: Alignment = Neutral
  private var _hitPoints = 5
  private var _armorClass = 10
  private var _attackDamage = 1
  private val _naturalTwenty = 20
  
  private val _strength: Abilities = Strength
  private val _constitution: Abilities = Constitution
  private val _dexterity: Abilities = Dexterity
  private val _intelligence: Abilities = Intelligence
  private val _wisdom: Abilities = Wisdom
  private val _charisma: Abilities = Charisma
  
  private val _experiencePoints: Attributes = ExperiencePoints
  private val _level: Attributes = Level

  private val _strengthModifier = strength.abilitiesModifiers.getOrElse(_strength.value, 0)

  //Getters
  def name = _name
  def alignment = _alignment
  def attackDamage = _attackDamage
  def hitPoints = _hitPoints
  def armorClass = _armorClass
  def experiencePoints = _experiencePoints
  def level = _level
  def strength = _strength
  def strengthModifier = _strengthModifier
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
  
  def attack(s: Int, opponent: Adventurer) = {
    calculateHit(s, opponent)
  }
  
  def calculateHit(s: Int, o: Adventurer) = {
    if (wasCritical(s)) o._hitPoints -= (_attackDamage + _strengthModifier * 2) * 2 else if (didHit(s, o)) o._hitPoints -= _attackDamage
  }
  
  def didHit(s: Int, o: Adventurer): Boolean = {
    modifyAttackRoll(s) >= o.armorClass
  }
  
  def wasCritical(s: Int): Boolean = {
    s == _naturalTwenty
  }
  
  def modifyAttackRoll(ar: Int): Int = {
    ar + _strengthModifier
  }
  
  def modifyAttackDamage: Int = {
    _attackDamage += _strengthModifier
    attackDamage
  }
  
  def isDead: Boolean = {
    this._hitPoints <= 0
  }
  
  def applyModifier(a: Abilities, i: Int) = {
    a.modifyBy(i)
  }
  
  
}
