package com.dj

import org.scalatest._

class UrinalSpec extends FlatSpec with Matchers {
  "Urinal" should "default to Available status when created" in {
    val urinal: Urinal = new Urinal

    Available should === (urinal.status)
  }

  "Urinal" should "return isAvailable true when created" in {
    val urinal: Urinal = new Urinal

    true should === (urinal.isAvailable())
  }

  "Urinal" should "return Occupied status when set properly" in {

    var urinal: Urinal = new Urinal
    urinal.status = Occupied

    Occupied should === (urinal.status)
  }

  "Urinal" should "return isAvailable false when created" in {
    var urinal: Urinal = new Urinal
    urinal.status = Occupied

    false should === (urinal.isAvailable())
  }

  "Urinal" should "return position 0 upon initial creation" in {
    val urinal: Urinal = new Urinal

    0 should === (urinal.position)
  }

  "Urinal" should "return properly assigned position after setting" in {
    var urinal: Urinal = new Urinal
    urinal.position = 1

    1 should === (urinal.position)
  }

  "Urinal" should "be unavailable when status is occupied" in {

    var urinal: Urinal = new Urinal
    urinal.status = Occupied

    false should === (urinal.isAvailable())

  }

  "Urinal" should "not have an empty left neighbor by default" in {

    var urinal: Urinal = new Urinal

    false should === (urinal.hasLeftNeighbor())
  }

  "Urinal" should "have a left neighbor when set" in {

    var urinal: Urinal = new Urinal
    urinal.leftNeighbor = new Urinal

    true should === (urinal.hasLeftNeighbor())
  }

  "Urinal" should "not have an empty right neighbor by default" in {

    var urinal: Urinal = new Urinal

    false should === (urinal.hasRightNeighbor())
  }

  "Urinal" should "have a right neighbor when set" in {

    var urinal: Urinal = new Urinal
    urinal.rightNeighbor = new Urinal

    true should === (urinal.hasRightNeighbor())
  }

  "Urinal" should "return score of 0 when occupied" in {

    var urinal: Urinal = new Urinal
    urinal.status = Occupied
    urinal.leftNeighbor == None
    urinal.rightNeighbor == None

    0 should === (urinal.getScore())
  }

  "Urinal" should "return score of 1 when available, with occupied left and right" in {

    var urinal: Urinal = new Urinal
    urinal.status = Available

    var leftUrinal: Urinal = new Urinal
    leftUrinal.status = Occupied
    urinal.leftNeighbor = leftUrinal

    var rightUrinal: Urinal = new Urinal
    rightUrinal.status = Occupied
    urinal.rightNeighbor = rightUrinal

    1 should === (urinal.getScore())
  }
}

//  def "an available urinal, in first position, with an non-existent left neighbor and occupied right neighbor should be considered available"() {
//  given: "instantiated Urinal"
//  def urinal = new Urinal()
//  urinal.status = UrinalStatus.AVAILABLE
//
//  when: "left neighbor does not exist"
//  urinal.leftNeighbor = null
//
//  and: "right neighbor is occupied"
//  def right = new Urinal()
//  right.status = UrinalStatus.OCCUPIED
//  urinal.rightNeighbor = right
//
//  then: "urinal is considered available"
//  urinal.isAvailable() == true
//}
//
//  def "an available urinal, in last position, with an occupied left and non-existent right neighbor should be considered available"() {
//  given: "instantiated Urinal"
//  def urinal = new Urinal()
//  urinal.status = UrinalStatus.AVAILABLE
//
//  when: "right neighbor does not exist"
//  urinal.rightNeighbor = null
//
//  and: "left neighbor is occupied"
//  def left = new Urinal()
//  left.status = UrinalStatus.OCCUPIED
//  urinal.leftNeighbor = left
//
//  then: "urinal is considered available"
//  urinal.isAvailable() == true
//}
