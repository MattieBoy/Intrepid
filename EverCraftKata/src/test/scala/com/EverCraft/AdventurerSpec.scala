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
  
  "Opponent" should "be hit if Adventurers attackRoll is >= to opponent armor class" in {
    val subject = new Adventurer
    val opponent = new Adventurer
    opponent.armorClass = 2
    val hit = subject.didHit(13, opponent)
    
    true shouldBe hit
  }

  "Opponent" should "not be hit if Adventurers attackRoll is <= to opponent armor class" in {
    val subject = new Adventurer
    val opponent = new Adventurer
    val hit = subject.didHit(2, opponent)

    false shouldBe hit
  }

  "Opponent" should "be hit if Adventurers attackRoll is == to opponent armor class" in {
    val subject = new Adventurer
    val opponent = new Adventurer
    val hit = subject.didHit(10, opponent)

    true shouldBe hit
  }
  
  //Not sure this test is meaningful. need to figure out how to control the roll rather than set opponent AC?
  "Adventurer" should "be able to attack and damage an opponent" in {
    val subject = new Adventurer
    val opponent = new Adventurer
    opponent.hitPoints = 5
    subject.attack(19, opponent)
    
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
    val modifiedRoll = subject.modifyAttackRoll(1)
    2 shouldBe modifiedRoll
  }

  "Adventurer" should "have attack damage modified by Strength" in {
    Strength.value = 12
    val subject = new Adventurer
    val modifiedDamage = subject.modifyAttackDamage

    2 shouldBe modifiedDamage
  }

  "Adventurer" should "score critical hit on natural 20" in {
    Strength.value = 12
    val subject = new Adventurer
    val crit = subject.wasCritical(20)
    
    true shouldBe crit
  }

  "Adventurer" should "deal double damage on critical hit" in {
    Strength.value = 12
    val subject = new Adventurer
    val opponent = new Adventurer
    opponent.hitPoints = 10
    subject.calculateHit(20, opponent)
    
    4 shouldBe opponent.hitPoints
  }
  
  
}
