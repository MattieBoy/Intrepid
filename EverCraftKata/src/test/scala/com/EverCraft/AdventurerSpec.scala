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
    val attackStrike = subject.strike
    
    attackStrike should be <= 20
    attackStrike should be >= 1
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
    subject.attack(opponent)
    
    4 should === (opponent.hitPoints)
  }
  
  "Adventurer" should "be able to kill opponent when their hit points are reduced to zero" in  {
    val subject = new Adventurer
    val opponent = new Adventurer
    opponent.hitPoints = 1
    subject.attack(opponent)
    
    true should === (opponent.isDead)
  }
  
  
}
