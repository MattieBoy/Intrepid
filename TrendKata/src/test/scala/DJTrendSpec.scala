import com.example.DJTrend
import org.scalatest._

class DJTrendSpec extends FlatSpec with Matchers {

  "TrendUtils" should "return null when supplied list is null" in {
    DJTrend.findTrend(null) should be (Nil)
  }
}
