import com.example.DJTrendFunction
import org.scalatest._

class DJTrendFunctionSpec extends FlatSpec with Matchers {

  "TrendUtils" should "return zero when supplied list only contain a single value" in {
    DJTrendFunction.findTrend(List(1.0)) should be(0.0)
  }

  "TrendUtils" should "return 1.0 when P1 equals zero and p2 greater than zero" in {
    DJTrendFunction.findTrend(List(0.0, 1.0)) should be (1.0)
  }

  "TrendUtils" should "return 0.0 when P1 equals P2" in {
    DJTrendFunction.findTrend(List(1.0, 1.0)) should be (0.0)
  }

  "TrendUtils" should "return proper value when real values passed" in {
    DJTrendFunction.findTrend(List(5.0, 10.0)) should be (1.0)
  }

  "TrendUtils" should "return proper value when three values supplied" in {
    DJTrendFunction.findTrend(List(0.0, 5.0, 10.0)) should be (2.0)
  }

}
