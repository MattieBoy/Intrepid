package com.mattie
import org.scalatest._

class MattieUrinalSpec extends FlatSpec with Matchers {
  
  "Restroom" should "populate a collection of urinals when created" in {
    val restroom = new Restroom(3)

    restroom.urinals.size should equal(3)
  }

  "Restroom" should "reset rank to zero for unoccupied urinals" in {
    val restroom = new Restroom(4)
    restroom.urinals(3).status = Occupied
    val newUrinals = MattieUrinal.resetRanks(restroom.urinals)

    newUrinals(0).rank should equal(0)
    newUrinals(1).rank should equal(0)
    newUrinals(2).rank should equal(0)
    newUrinals(3).rank should equal(4)
  }

  "Restroom" should "update rank values for unoccupied urinals" in {
    val restroom = new Restroom(4)
    MattieUrinal.resetRanks(restroom.urinals)
    restroom.urinals(0).status = Occupied

    MattieUrinal.updateRanks(restroom.urinals)

    restroom.urinals(0).rank should equal(0)
    restroom.urinals(1).rank should equal(0)
    restroom.urinals(2).rank should equal(2)
    restroom.urinals(3).rank should equal(2)
  }

  "Urinal" should "have properties set when created" in {
    val uri = new Urinal(Available, 1)
    uri.status should equal(Available)
    uri.leftNeighbor should equal(null)
    uri.rightNeighbor should equal(null)
    uri.rank should equal(1)
  }
  
  "GetMax" should "get urinal with largest rank" in {
    val u1 = new Urinal(Available, 3)
    val u2 = new Urinal(Available, 2)
    
    val result = MattieUrinal.whichIsHighestRankedUrinal(u1, u2)

    result.rank should equal(3)
  }

  "ChooseUrinal" should "choose urinal with the highest rank" in {
    val restroom = new Restroom(4)
    MattieUrinal.resetRanks(restroom.urinals)
    MattieUrinal.updateRanks(restroom.urinals)
    MattieUrinal.chooseUrinal(restroom.urinals)


    restroom.urinals(1).status should equal(Available)
    restroom.urinals(2).status should equal(Available)
    restroom.urinals(3).status should equal(Occupied)
  }
  
  "ChooseUrinal" should "choose appropriate urinal given same rank" in {
    val restroom = new Restroom(4)
    restroom.urinals(0).rank = 0
    restroom.urinals(1).rank = 2
    restroom.urinals(2).rank = 2
    restroom.urinals(3).rank = 2
    
    MattieUrinal.chooseUrinal(restroom.urinals)

    restroom.urinals(0).status should equal(Available)
    restroom.urinals(1).status should equal(Available)
    restroom.urinals(2).status should equal(Available)
    restroom.urinals(3).status should equal(Occupied)
  }

//  "MattieSpec" should "execute properly" in {
//    MattieUrinal.main(4)
//  }
  
}
