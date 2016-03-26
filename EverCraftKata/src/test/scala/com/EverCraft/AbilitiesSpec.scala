package com.EverCraft

import org.scalatest._
/**
 * Created by matthewrighter on 3/25/16.
 */
class AbilitiesSpec extends FlatSpec with Matchers {
  "Abilities" should "default all values to 10" in {
    val abilities = new Abilities
    
    10 should === (abilities.strength)
    10 should === (abilities.dexterity)
    10 should === (abilities.constitution)
    10 should === (abilities.intelligence)
    10 should === (abilities.wisdom)
    10 should === (abilities.charisma)
  }
}
