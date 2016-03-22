package com.dj

import org.scalatest._

class Bathroom_4UrinalsSpec extends FlatSpec with Matchers {
  "Bathroom" should "return position 4 when 4 urinals exist and all urinals are available" in {
    val bathroom: Bathroom = new Bathroom(4)

    4 should ===(bathroom.numberOfUrinals)

    bathroom.getOptionalUrinalByPosition(4).get should ===(bathroom.nextAvailable.get)
  }

  "Bathroom" should "return position 1 when 4 urinals exist and 2, 3, 4 are occupied" in {
    val bathroom: Bathroom = new Bathroom(4)
    bathroom.getOptionalUrinalByPosition(2).get.status = Occupied
    bathroom.getOptionalUrinalByPosition(3).get.status = Occupied
    bathroom.getOptionalUrinalByPosition(4).get.status = Occupied

    4 should ===(bathroom.numberOfUrinals)

    bathroom.getOptionalUrinalByPosition(1).get should ===(bathroom.nextAvailable.get)
  }

  "Bathroom" should "return position 1 when 4 urinals exist and 2 and 4 are occupied" in {
    val bathroom: Bathroom = new Bathroom(4)
    bathroom.getOptionalUrinalByPosition(2).get.status = Occupied
    bathroom.getOptionalUrinalByPosition(4).get.status = Occupied

    4 should ===(bathroom.numberOfUrinals)

    bathroom.getOptionalUrinalByPosition(1).get should ===(bathroom.nextAvailable.get)
  }

  "Bathroom" should "return position 3 when 4 urinals exist and 1 and 4 are occupied" in {
    val bathroom: Bathroom = new Bathroom(4)
    bathroom.getOptionalUrinalByPosition(1).get.status = Occupied
    bathroom.getOptionalUrinalByPosition(4).get.status = Occupied

    4 should ===(bathroom.numberOfUrinals)

    bathroom.getOptionalUrinalByPosition(3).get should ===(bathroom.nextAvailable.get)
  }
}
