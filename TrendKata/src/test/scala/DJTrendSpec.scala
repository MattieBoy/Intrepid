import com.example.DJTrend
import org.scalatest._

class DJTrendSpec extends FlatSpec with Matchers {

  "TrendUtils" should "return zero when supplied list is Nil" in {
    DJTrend.findTrend(Nil) should be(0.0)
  }

  "TrendUtils" should "return zero when supplied list is empty" in {
    DJTrend.findTrend(List[Double]()) should be(0.0)
  }

  "TrendUtils" should "return zero when supplied list only contain a single value" in {
    DJTrend.findTrend(List(1.0)) should be(0.0)
  }

  "TrendUtils" should "return 1.0 when P1 equals zero and p2 greater than zero" in {
    DJTrend.findTrend(List(0.0, 1.0)) should be (1.0)
  }

}
