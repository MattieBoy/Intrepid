import org.scalatest._
import com.example.MattieTrend

class MattieTrendSpec extends FlatSpec with Matchers {
  "MattieTrend" should "return nil if list is empty" in {
    MattieTrend.calculateTrend(List[Int]()) should be(None)
  }
}
