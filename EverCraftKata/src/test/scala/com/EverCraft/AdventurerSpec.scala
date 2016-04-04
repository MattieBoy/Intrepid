package com.EverCraft

import org.scalatest._

class AdventurerSpec extends FlatSpec with Matchers {
  "Adventurer" should "be able to be given a name" in {
    val subject = new Adventurer
    subject.name = "Colonel Rhombus"
    
    "Colonel Rhombus" should === (subject.name)
  }
  
  "Adventurer" should "have a Neutral alignment by default" in {
    val subject = new Adventurer
    
    Neutral should === (subject.alignment)
  }
  
  "Adventurer" should "be able to have their alignment set" in {
    val subject = new Adventurer
    subject.alignment = Good
    
    Good should === (subject.alignment)
  }
  
  "Adventurer" should "have 5 hit points by default" in {
    val subject = new Adventurer
    
    5 should === (subject.hitPoints)
  }
  
  "Adventurer" should "have an Armor Class of 10 by default" in {
    val subject = new Adventurer
    
    10 should === (subject.armorClass)
  }
  
  "Adventurer" should "be able to strike another adventurer by rolling a value between 1 - 20" in {
    val subject = new Adventurer
    subject.strike

    subject.attackRoll should be <= 20
    subject.attackRoll should be >= 1
  }
  
  "Opponent" should "be hit if Adventurers attackRoll is >= to opponent armor class" in {
    val subject = new Adventurer
    val opponent = new Adventurer
    val attackRoll = 13
    subject.calculateHit(attackRoll, opponent)
    
    4 should === (opponent.hitPoints)
  }

  "Opponent" should "not be hit if Adventurers attackRoll is <= to opponent armor class" in {
    val subject = new Adventurer
    val opponent = new Adventurer
    val attackRoll = 5
    subject.calculateHit(attackRoll, opponent)

    5 should === (opponent.hitPoints)
  }

  "Opponent" should "be hit if Adventurers attackRoll is == to opponent armor class" in {
    val subject = new Adventurer
    val opponent = new Adventurer
    val attackRoll = 10
    subject.calculateHit(attackRoll, opponent)

    4 should === (opponent.hitPoints)
  }
  
  //Not sure this test is meaningful. need to figure out how to control the roll rather than set opponent AC?
  "Adventurer" should "be able to attack and damage an opponent" in {
    val subject = new Adventurer
    val opponent = new Adventurer
    opponent.armorClass = 1
    opponent.hitPoints = 5
    subject.attack(opponent)
    
    4 should === (opponent.hitPoints)
  }
  
  //override random roll calculator to direct
  
  "Adventurer" should "be able to kill opponent when their hit points are reduced to zero" in {
    val subject = new Adventurer
    subject.hitPoints = 0

    true should === (subject.isDead)
  }
  
  "Adventurer" should "not be allowed to have an ability score greater than 20" in {
    Strength.value = 10
    val subject = new Adventurer
    subject.strength.modifyBy(20)

    20 should === (subject.strength.value)
  }

  "Adventurer" should "not be allowed to have an ability score less than 1" in {
    Strength.value = 10
    val subject = new Adventurer
    subject.strength.modifyBy(-20)
    
    1 should ===(subject.strength.value)
  }
  
  "Adventurer" should "be able to have ability modified with a random value for uniqueness" in {
    Strength.value = 10
    val subject = new Adventurer
    
    subject.randomizedModify(Strength)
    20 should be >= Strength.value 
    1 should be <= Strength.value
  }
  
  "Adventurer" should "have initial ability scores randomly modified for uniqueness" in {
    val subject = new Adventurer
    subject.setModifiedAbilities(subject.adventurerAbilities)
    
    println("Strength is = " + Strength.value)
    println("Dexterity is = " + Dexterity.value)
  }

  "Adventurer" should "have hit points modified by Constitution score" in {
    Constitution.value = 10
    val subject = new Adventurer
    subject.hitPoints = 5
    subject.constitution.modifyBy(2)
    subject.applyConstitutionModifier
    
    6 shouldBe subject.hitPoints
  }

  "Adventurer" should "have armor class modified by Dexterity Score" in {
    Dexterity.value = 10
    val subject = new Adventurer
    subject.armorClass = 10
    subject.dexterity.modifyBy(2)
    subject.applyDexterityModifier
    
    11 shouldBe subject.armorClass
  }

  "Adventurer" should "have attack roll modified by Strength" in {
    Strength.value = 12
    val subject = new Adventurer
    subject.modifyAttackRoll
    
    1 shouldBe subject.attackRoll
  }
}
