package com.example

object MattieTrend {
  def calculateTrend(list: List[Int]) : Option[Int] = {
    if (list.isEmpty) {
      return None
    } else {
      return Some(10)
    }
  }
}
