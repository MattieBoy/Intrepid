package com.EverCraft

import com.EverCraft
import org.scalatest._
/**
 * Created by matthewrighter on 3/25/16.
 */
class AbilitiesSpec extends FlatSpec with Matchers {
  "Abilities" should "default all values to 10" in {
    10 should === (Strength.value)
    10 should === (Dexterity.value)
    10 should === (Constitution.value)
    10 should === (Intelligence.value)
    10 should === (Wisdom.value)
    10 should === (Charisma.value)
  }

  "Abilities" should "check if value is > 20" in {
    Strength.value = 10

    true shouldBe Strength.isTooHigh(22)
  }

  "Abilities" should "check if value is < 1" in {
    Strength.value = 10

    true shouldBe Strength.isTooLow(-20)
  }

  "Abilities" should "be able to be modified" in  {
    Strength.value = 10
    Strength.modifyBy(3)
      
    13 shouldBe Strength.value
  }
}
