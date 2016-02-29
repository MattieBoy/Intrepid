package com.example

object DJTrend {
  def findTrend(list: List[Double]): Double = {
    if (list == Nil) return 0.0

    if (list.size == 1) return 0.0

    if (list.head == 0.0 && list.last > 0.0) return 1.0

    return (list.last - list.head)/list.head

  }
}
