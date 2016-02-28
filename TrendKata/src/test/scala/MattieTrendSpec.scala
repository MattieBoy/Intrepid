import org.scalatest._
import com.example.MattieTrend

class MattieTrendSpec extends FlatSpec with Matchers {
  "MattieTrend" should "return nil if list is empty" in {
    MattieTrend.calculateTrend(List[Double]()) should be(None)
  }

  "MattieTrend" should "return nil if list does not exist" in {
    MattieTrend.calculateTrend(Nil) should be(None)
  }

  "MattieTrend" should "return zero if list has only one element" in {
    val list: List[Double] = List(2.0)
    MattieTrend.calculateTrend(list) should be(Some(0.0))
  }
}
