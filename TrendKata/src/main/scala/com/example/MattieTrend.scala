package com.example

object MattieTrend {
  def calculateTrend(list: List[Double]) : Option[Double] = {
    
    var result: Double = 0.0
    
    if (list.isEmpty) {
      return None
    } else if (list.length == 1) {
      return Some(0.0)
    } else {
      val slidPairs: List[List[Double]] = list.sliding(2).toList
      slidPairs.foreach{(pair: List[Double]) => 
        val pairValue: Double = calculatePairs(pair(0), pair(1))
        result = result + pairValue
      }
      return Some(result)
    }
  }
  
  def calculatePairs(p1: Double, p2: Double) : Double = {
    if (p1 == 0 && p2 > 0) 1.0 else if (p1 == p2) 0.0 else ((p2 - p1) / p1)
  }
}
