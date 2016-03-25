package com.EverCraft

import org.scalatest._

class AdventurerSpec extends FlatSpec with Matchers {
  "Adventurer" should "be able to be given a name" in {
    val hero = new Adventurer()
    hero.name = "Colonel Rhombus" 
    "Colonel Rhombus" should === (hero.name)
  }
}
