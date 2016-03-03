package com.example

object DJTrendSliding {

  type Trend = (Double, Double)
  val c: Trend => Double = (t) =>  calculatePairValue(t._1, t._2)

  def calculatePairValue(left: Double, right: Double): Double = {
    if (left == 0.0 && right == 0.0) return 0.0
    if (left == 0.0 && right > 0.0) return 1.0
    (right - left) / left
  }

  def findTrend(list: List[Double]): Double = {
    if (list.size == 1) return 0.0

    list.sliding(2, 1).map { case Seq(d1, d2) => (d1, d2) }.map(c).sum
  }
}



