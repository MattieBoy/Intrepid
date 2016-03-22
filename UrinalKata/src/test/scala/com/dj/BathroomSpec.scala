package com.dj

import org.scalatest._

class BathroomSpec extends FlatSpec with Matchers {
  "Bathroom" should "default to zero urinals" in {
    val bathroom: Bathroom = new Bathroom

    0 should ===(bathroom.numberOfUrinals)
  }

  "Bathroom" should "return proper urinal by position" in {
    val bathroom: Bathroom = new Bathroom(2)

    bathroom.urinals(1) should === (bathroom.getUrinalByPosition(2).get)
  }

  "Bathroom" should "create proper number of urinals" in {
    val bathroom: Bathroom = new Bathroom(1)

    1 should === (bathroom.urinals.length)
    1 should === (bathroom.numberOfUrinals)
  }

  "Bathroom" should "create two urinals and proper neighbor relationships" in {
    val bathroom: Bathroom = new Bathroom(2)

    2 should ===(bathroom.urinals.length)
    2 should === (bathroom.numberOfUrinals)

    false should ===(bathroom.getUrinalByPosition(1).get.hasLeftNeighbor())
    bathroom.getUrinalByPosition(1).get.rightNeighbor === (bathroom.getUrinalByPosition(2).get)
    bathroom.getUrinalByPosition(2).get.leftNeighbor === (bathroom.getUrinalByPosition(1)).get
    false should ===(bathroom.getUrinalByPosition(2).get.hasRightNeighbor())

  }

  //  def "Bathroom should create two urinals and proper neighbor relationships"() {
  //    given: "instantiated Urinal"
  //    def bathroom = new Bathroom(2)
  //
  //    expect: "2 urinal in the bathroom and linked properly"
  //    bathroom.numberOfUrinals() == 2
  //
  //    def urinals = bathroom.urinals
  //    bathroom.getUrinalByPosition(1).leftNeighbor == null
  //    bathroom.getUrinalByPosition(1).rightNeighbor == bathroom.getUrinalByPosition(2)
  //    bathroom.getUrinalByPosition(2).leftNeighbor == bathroom.getUrinalByPosition(1)
  //    bathroom.getUrinalByPosition(2).rightNeighbor == null
  //  }
  //
  //  def "Bathroom should create three urinals and proper neighbor relationships"() {
  //    given: "instantiated Urinal"
  //    def bathroom = new Bathroom(3)
  //
  //    expect: "3 urinal in the bathroom and linked properly"
  //    bathroom.numberOfUrinals() == 3
  //
  //    def urinals = bathroom.urinals
  //    urinals.get(0).leftNeighbor == null
  //    urinals.get(0).rightNeighbor == urinals.get(1)
  //    urinals.get(1).leftNeighbor == urinals.get(0)
  //    urinals.get(1).rightNeighbor == urinals.get(2)
  //    urinals.get(2).leftNeighbor == urinals.get(1)
  //    urinals.get(2).rightNeighbor == null
  //  }
  //
  //  def "Bathroom should create four urinals and proper neighbor relationships"() {
  //    given: "instantiated Urinal"
  //    def bathroom = new Bathroom(4)
  //
  //    expect: "4 urinal in the bathroom and linked properly"
  //    bathroom.numberOfUrinals() == 4
  //
  //    def urinals = bathroom.urinals
  //    urinals.get(0).leftNeighbor == null
  //    urinals.get(0).rightNeighbor == urinals.get(1)
  //    urinals.get(1).leftNeighbor == urinals.get(0)
  //    urinals.get(1).rightNeighbor == urinals.get(2)
  //    urinals.get(2).leftNeighbor == urinals.get(1)
  //    urinals.get(2).rightNeighbor == urinals.get(3)
  //    urinals.get(3).leftNeighbor == urinals.get(2)
  //    urinals.get(3).rightNeighbor == null
  //  }
  //
  //  def "should return urinal position 0 when no urinals exist"() {
  //    given: "instantiated Urinal"
  //    def bathroom = new Bathroom(0)
  //
  //    expect: "no available urinals"
  //    bathroom.numberOfUrinals() == 0
  //    bathroom.nextAvailable() == null
  //  }
  //
  //  def "should return urinal position 0 when only 1 urinal exists and is occupied"() {
  //    given: "instantiated Urinal"
  //    def bathroom = new Bathroom(1)
  //    bathroom.urinals.head().status = UrinalStatus.OCCUPIED
  //
  //    expect: "position 1 urinal is occupied"
  //    bathroom.numberOfUrinals() == 1
  //    bathroom.nextAvailable() == null
  //  }
  //
  //  def "should return urinal position 1 when only 1 urinal exists and is available"() {
  //    given: "instantiated Urinal"
  //    def bathroom = new Bathroom(1)
  //
  //    expect: "position 1 urinal is available"
  //    bathroom.numberOfUrinals() == 1
  //    bathroom.nextAvailable() == bathroom.getUrinalByPosition(1)
  //    1 == bathroom.urinals.head().position
  //  }
  //
  //  def "should return urinal position 2 when two urinals exist and both are available"() {
  //    given: "instantiated Urinal"
  //    def bathroom = new Bathroom(2)
  //
  //    expect: "position 2 should be returned"
  //    bathroom.numberOfUrinals() == 2
  //    bathroom.nextAvailable() == bathroom.getUrinalByPosition(2)
  //    2 == bathroom.getUrinalByPosition(2).position
  //  }
  //
  //  def "should return position 2 urinal when two urinals exists and position 1 is occupied"() {
  //    given: "instantiated Urinal"
  //    def bathroom = new Bathroom(2)
  //
  //    when: "position 1 is occupied"
  //    bathroom.urinals.get(0).status = UrinalStatus.OCCUPIED
  //
  //    then: "position 2 should be returned"
  //    bathroom.numberOfUrinals() == 2
  //    bathroom.nextAvailable() == bathroom.urinals.get(1)
  //    2 == bathroom.urinals.get(1).position
  //  }
  //
  //  def "should return position 1 urinal when two urinals exists and position 2 is occupied"() {
  //    given: "instantiated Urinal"
  //    def bathroom = new Bathroom(2)
  //
  //    when: "position 2 is occupied"
  //    bathroom.getUrinalByPosition(2).status = UrinalStatus.OCCUPIED
  //
  //    then: "position 1 should be returned"
  //    bathroom.numberOfUrinals() == 2
  //    bathroom.nextAvailable() == bathroom.urinals.get(0)
  //    1 == bathroom.getUrinalByPosition(1).position
  //  }
  //
  //  def "should return urinal position 0 when two urinals exists and both positions are occupied"() {
  //    given: "instantiated Urinal"
  //    def bathroom = new Bathroom(2)
  //
  //    when: "position 1 is occupied"
  //    bathroom.getUrinalByPosition(1).status = UrinalStatus.OCCUPIED
  //
  //    and: "position 2 is occupied"
  //    bathroom.getUrinalByPosition(2).status = UrinalStatus.OCCUPIED
  //
  //    then: "no available urinals"
  //    bathroom.numberOfUrinals() == 2
  //    bathroom.nextAvailable() == null
  //  }
}
