import com.example.DJTrendSliding
import org.scalatest.{Matchers, FlatSpec}

class DJTrendSlidingSpec extends FlatSpec with Matchers {

  "TrendUtils" should "return zero when supplied list is Nil" in {
    DJTrendSliding.findTrend(Nil) should be(0.0)
  }

  "TrendUtils" should "return zero when supplied list is empty" in {
    DJTrendSliding.findTrend(List[Double]()) should be(0.0)
  }

  "TrendUtils" should "return zero when supplied list only contain a single value" in {
    DJTrendSliding.findTrend(List(1.0)) should be(0.0)
  }

  "TrendUtils" should "return 1.0 when P1 equals zero and p2 greater than zero" in {
    DJTrendSliding.findTrend(List(0.0, 1.0)) should be (1.0)
  }

  "TrendUtils" should "return 0.0 when P1 equals P2" in {
    DJTrendSliding.findTrend(List(1.0, 1.0)) should be (0.0)
  }

  "TrendUtils" should "return proper value when real values passed" in {
    DJTrendSliding.findTrend(List(5.0, 10.0)) should be (1.0)
  }

  "TrendUtils" should "return proper value when three values supplied" in {
    DJTrendSliding.findTrend(List(0.0, 5.0, 10.0)) should be (2.0)
  }

}
