import com.example.DJTrendFunction
import org.scalatest.{FlatSpec, Matchers}

class DJTrendFunctionE2ESpec extends FlatSpec with Matchers {

  "TrendUtils" should "return zero when supplied list is single number" in {
    DJTrendFunction.findTrend(List(90.0)) should be (0.0)
  }


  "TrendUtils" should "return proper percentage when list of two numbers is increasing" in {
    DJTrendFunction.findTrend(List(90.0, 100)) should be (0.1111111111111111)
  }

  "TrendUtils" should "return proper percentage when list of three numbers is increasing" in {
    DJTrendFunction.findTrend(List(90.0, 100.0, 110.0)) should be (0.2111111111111111)
  }

  "TrendUtils" should "return proper percentage when list of three numbers is increasing (another variation)" in {
    DJTrendFunction.findTrend(List(20.0, 60.0, 110.0)) should be (2.8333333333333335)
  }

  "TrendUtils" should "return proper percentage when list of four numbers is increasing" in {
    DJTrendFunction.findTrend(List(20.0, 60.0, 110.0, 150.0)) should be (3.1969696969696972)
  }

  "TrendUtils" should "return proper percentage when list of two numbers is decreasing" in {
    DJTrendFunction.findTrend(List(100.0, 90.0)) should be (-0.1)
  }

  "TrendUtils" should "return proper percentage when list of three numbers is decreasing" in {
    DJTrendFunction.findTrend(List(110.0, 100.0, 90.0)) should be (-0.19090909090909092)
  }

  "TrendUtils" should "return proper percentage when first number is zero and second number is positive" in {
    DJTrendFunction.findTrend(List(0.0, 50.0)) should be (1.0)
  }

  "TrendUtils" should "return proper percentage when first number is zero and second number is zero" in {
    DJTrendFunction.findTrend(List(0.0, 0.0)) should be (0.0)
  }

  "TrendUtils" should "return zero when both numbers are equal" in {
    DJTrendFunction.findTrend(List(10.0, 10.0)) should be (0.0)
  }

  "TrendUtils" should "return proper percentage when first number is zero" in {
    DJTrendFunction.findTrend(List(0.0, 50.0, 60.0)) should be (1.2)
  }

  "TrendUtils" should "return proper percentage when all zeroes" in {
    DJTrendFunction.findTrend(List(0.0, 0.0, 0.0)) should be (0.0)
  }

  "TrendUtils" should "return proper percentage when fluxuation up and down" in {
    DJTrendFunction.findTrend(List(10.0, 20.0, 10.0)) should be (0.5)
  }

  "TrendUtils" should "return handle real world example" in {
    DJTrendFunction.findTrend(List(2556.0, 1160.0, 1050.0, 369.0)) should be (-1.2895648989723782)
  }

  "TrendUtils" should "return handle real world example 2" in {
    DJTrendFunction.findTrend(List(876.0, 920.0, 920.0, 920.0)) should be (0.0502283105022831)
  }

  "TrendUtils" should "return handle real world example 3" in {
    DJTrendFunction.findTrend(List(0.35530768392370576, 0.38223999999999997, 0.38223999999999997)) should be (0.07579998208560361)
  }
}


