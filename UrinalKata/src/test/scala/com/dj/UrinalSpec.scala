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
}

//  def "urinal should be unavailable when status is occupied"() {
//  given: "instantiated Urinal"
//  def urinal = new Urinal()
//
//  when: "status is occupied"
//  urinal.status = UrinalStatus.OCCUPIED
//
//  then: "expect Urinal to be unavailable when occupied"
//  urinal.isAvailable() == false
//}
//
//  def "urinal can have an empty left neighbor"() {
//  given: "instantiated Urinal"
//  def urinal = new Urinal()
//
//  when: "status is occupied"
//  urinal.leftNeighbor = null
//
//  then: "urinal has no left neighbor"
//  urinal.hasLeftNeighbor() == false
//}
//
//  def "urinal has a left neighbor"() {
//  given: "instantiated Urinal"
//  def urinal = new Urinal()
//
//  when: "status is occupied"
//  urinal.leftNeighbor = new Urinal()
//
//  then: "urinal has left neighbor"
//  urinal.hasLeftNeighbor() == true
//}
//
//  def "urinal can have an empty right neighbor"() {
//  given: "instantiated Urinal"
//  def urinal = new Urinal()
//
//  when: "status is occupied"
//  urinal.rightNeighbor = null
//
//  then: "urinal has no right neighbor"
//  urinal.hasRightNeighbor() == false
//}
//
//  def "urinal has a right neighbor"() {
//  given: "instantiated Urinal"
//  def urinal = new Urinal()
//
//  when: "status is occupied"
//  urinal.rightNeighbor = new Urinal()
//
//  then: "urinal has right neighbor"
//  urinal.hasRightNeighbor() == true
//}
//
//  def "an available urinal, with an occupied left and right neighbor should be considered occupied"() {
//  given: "instantiated Urinal"
//  def urinal = new Urinal()
//  urinal.status = UrinalStatus.AVAILABLE
//
//  when: "left neighbor is occupied"
//  def left = new Urinal()
//  left.status = UrinalStatus.OCCUPIED
//  urinal.leftNeighbor = left
//
//  and: "right neighbor is occupied"
//  def right = new Urinal()
//  right.status = UrinalStatus.OCCUPIED
//  urinal.rightNeighbor = right
//
//  then: "urinal is considered not available"
//  urinal.isAvailable() == false
//}
//
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
