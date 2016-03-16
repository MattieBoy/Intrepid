package com.mattie
import org.scalatest._

class MattieUrinalSpec extends FlatSpec with Matchers {
  
  "Restroom" should "populate a collection of urinals when created" in {
    val restroom = new Restroom(3)
    
    restroom.urinals.size should equal(3)
  }
  
  "Restroom" should "reset rank to zero for unoccupied urinals" in {
    val restroom = new Restroom(4)
    restroom.urinals(3).occupied = true
    MattieUrinal.resetRanks(restroom.urinals)
    
    restroom.urinals(0).rank should equal(0)
    restroom.urinals(1).rank should equal(0)
    restroom.urinals(2).rank should equal(0)
    restroom.urinals(3).rank should equal(4)
  }
  
  "Restroom" should "update rank values for unoccupied urinals" in {
    val restroom = new Restroom(4)
    restroom.urinals(0).occupied = true
    
    MattieUrinal.updateRanks(restroom.urinals)

    restroom.urinals(0).rank should equal(0)
    restroom.urinals(1).rank should equal(1)
    restroom.urinals(2).rank should equal(3)
    restroom.urinals(3).rank should equal(2)
  }
  
  "Urinal" should "have properties set when created" in {
    val uri = new Urinal(false, 1)
    uri.occupied should equal(false)
    uri.leftNeighbor should equal(None)
    uri.rightNeighbor should equal(None)
    uri.rank should equal(1)
  }

  "ChooseUrinal" should "choose urinal with the highest rank" in {
    val restroom = new Restroom(4)
    MattieUrinal.chooseUrinal(restroom.urinals)
    
    restroom.urinals(0).occupied should equal(false)
    restroom.urinals(1).occupied should equal(false)
    restroom.urinals(2).occupied should equal(false)
    restroom.urinals(3).occupied should equal(true)
  }

  "MattieSpec" should "execute properly" in {
    MattieUrinal.execute(4)
  }
  
}
