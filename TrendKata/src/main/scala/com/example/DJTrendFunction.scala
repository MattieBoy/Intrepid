package com.example

object DJTrendFunction {

  def calculatePairValue(left: Double, right: Double): Double = {
    if (left == right) return 0.0
    if (left == 0.0 && right > 0.0) return 1.0
    (right - left) / left
  }

  def findTrend(list: List[Double]): Double = {
    type Trend = (Double, Double)
    val c: Trend => Double = (t) =>  calculatePairValue(t._1, t._2)

    if (list.size == 1) return 0.0

    val pairs = list.init zip list.tail
    pairs.map(c).sum
  }
}


