package com.dj

import org.scalatest._

class BathroomSpec extends FlatSpec with Matchers {
  "Bathroom" should "default to zero urinals" in {
    val bathroom: Bathroom = new Bathroom

    0 should ===(bathroom.numberOfUrinals)
  }

  "Bathroom" should "return proper urinal by position" in {
    val bathroom: Bathroom = new Bathroom(2)

    bathroom.urinals(1) should ===(bathroom.getUrinalOptionByPosition(2).get)
  }

  "Bathroom" should "create proper number of urinals" in {
    val bathroom: Bathroom = new Bathroom(1)

    1 should ===(bathroom.numberOfUrinals)
  }

  "Bathroom" should "create two urinals and proper neighbor relationships" in {
    val bathroom: Bathroom = new Bathroom(2)

    2 should ===(bathroom.numberOfUrinals)

    false should ===(bathroom.getUrinalOptionByPosition(1).get.hasLeftNeighbor())
    bathroom.getUrinalOptionByPosition(1).get.rightNeighbor === (bathroom.getUrinalOptionByPosition(2).get)
    bathroom.getUrinalOptionByPosition(2).get.leftNeighbor === (bathroom.getUrinalOptionByPosition(1)).get
    false should ===(bathroom.getUrinalOptionByPosition(2).get.hasRightNeighbor())

  }

  "Bathroom" should "create three urinals and proper neighbor relationships" in {

    val bathroom: Bathroom = new Bathroom(3)

    3 should ===(bathroom.numberOfUrinals)

    bathroom.getUrinalOptionByPosition(1).get.hasLeftNeighbor() should ===(false)
    bathroom.getUrinalOptionByPosition(1).get.rightNeighbor.get should ===(bathroom.getUrinalOptionByPosition(2).get)
    bathroom.getUrinalOptionByPosition(2).get.leftNeighbor.get should ===(bathroom.getUrinalOptionByPosition(1).get)
    bathroom.getUrinalOptionByPosition(2).get.rightNeighbor.get should ===(bathroom.getUrinalOptionByPosition(3).get)
    bathroom.getUrinalOptionByPosition(3).get.leftNeighbor.get should ===(bathroom.getUrinalOptionByPosition(2).get)
    bathroom.getUrinalOptionByPosition(3).get.hasRightNeighbor() should ===(false)

  }

  "Bathroom" should "create four urinals and proper neighbor relationships" in {

    val bathroom: Bathroom = new Bathroom(4)

    4 should ===(bathroom.numberOfUrinals)

    bathroom.getUrinalOptionByPosition(1).get.hasLeftNeighbor() should ===(false)
    bathroom.getUrinalOptionByPosition(1).get.rightNeighbor.get should ===(bathroom.getUrinalOptionByPosition(2).get)
    bathroom.getUrinalOptionByPosition(2).get.leftNeighbor.get should ===(bathroom.getUrinalOptionByPosition(1).get)
    bathroom.getUrinalOptionByPosition(2).get.rightNeighbor.get should ===(bathroom.getUrinalOptionByPosition(3).get)
    bathroom.getUrinalOptionByPosition(3).get.leftNeighbor.get should ===(bathroom.getUrinalOptionByPosition(2).get)
    bathroom.getUrinalOptionByPosition(3).get.rightNeighbor.get should ===(bathroom.getUrinalOptionByPosition(4).get)
    bathroom.getUrinalOptionByPosition(4).get.leftNeighbor.get should ===(bathroom.getUrinalOptionByPosition(3).get)
    bathroom.getUrinalOptionByPosition(4).get.hasRightNeighbor() should ===(false)

  }

  "Bathroom" should "zero urinals" in {

    val bathroom: Bathroom = new Bathroom(0)

    0 should ===(bathroom.numberOfUrinals)
  }

  "Bathroom" should "not have an available urinal when only one occupied" in {

    val bathroom: Bathroom = new Bathroom(1)
    bathroom.getUrinalOptionByPosition(1).get.status = Occupied

    1 should ===(bathroom.numberOfUrinals)
    None should ===(bathroom.nextAvailable)

  }

  "Bathroom" should "return urinal position 1 when only 1 urinal exists and is available" in {

    val bathroom: Bathroom = new Bathroom(1)

    1 should ===(bathroom.numberOfUrinals)
    bathroom.getUrinalOptionByPosition(1).get should ===(bathroom.nextAvailable.get)

  }

  "Bathroom" should "return urinal position 2 when 2 urinals exist and both available" in {

    val bathroom: Bathroom = new Bathroom(2)

    2 should ===(bathroom.numberOfUrinals)
    bathroom.getUrinalOptionByPosition(2).get should ===(bathroom.nextAvailable.get)

  }

  "Bathroom" should "return urinal position 2 when 2 urinals exist and 1 occupied" in {

    val bathroom: Bathroom = new Bathroom(2)
    bathroom.getUrinalOptionByPosition(1).get.status = Occupied


    2 should ===(bathroom.numberOfUrinals)
    bathroom.getUrinalOptionByPosition(2).get should ===(bathroom.nextAvailable.get)

  }

  "Bathroom" should "return urinal position 1 when 2 urinals exist and 2 occupied" in {

    val bathroom: Bathroom = new Bathroom(2)
    bathroom.getUrinalOptionByPosition(2).get.status = Occupied


    2 should ===(bathroom.numberOfUrinals)
    bathroom.getUrinalOptionByPosition(1).get should ===(bathroom.nextAvailable.get)

  }

  "Bathroom" should "return urinal position 0 when 2 urinals exist and both occupied" in {

    val bathroom: Bathroom = new Bathroom(2)
    bathroom.getUrinalOptionByPosition(1).get.status = Occupied
    bathroom.getUrinalOptionByPosition(2).get.status = Occupied


    2 should ===(bathroom.numberOfUrinals)
    None === (bathroom.nextAvailable)

  }
}
