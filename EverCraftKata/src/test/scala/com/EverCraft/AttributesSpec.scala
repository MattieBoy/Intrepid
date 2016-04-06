package com.EverCraft

import org.scalatest._
/**
 * Created by matthewrighter on 4/5/16.
 */
class AttributesSpec extends FlatSpec with Matchers {
  "Attributes" should "be able to accrue experience points" in {
    ExperiencePoints.accrue(10)
    
    10 shouldBe ExperiencePoints.value
  }

  "Attributes" should "be able to accrue levels" in {
    Level.accrue(1)
    
    2 shouldBe Level.value
  }
}
