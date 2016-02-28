package com.example

object MattieTrend {
  def calculateTrend(list: List[Double]) : Option[Double] = {
    if (list.isEmpty) {
      return None
    } else if (list.length == 1) {
      return Some(0.0)
    } else {
      return Some(10.0)
    }
  }
  
  def calculatePairs(p1: Double, p2: Double) : Double = {
    if (p1 == 0 && p2 > 0) 1.0 else if (p1 == p2) 0.0 else ((p2 - p1) / p1)
  }
}
