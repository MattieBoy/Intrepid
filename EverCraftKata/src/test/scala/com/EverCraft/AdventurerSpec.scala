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
}
