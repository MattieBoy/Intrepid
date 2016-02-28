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

  "MattieTrend" should "return trend value when list contains whole numbers and decimals" in {
    val list: List[Double] = List(2.0, 4, 8.0)
    MattieTrend.calculateTrend(list) should be(Some(2.0))
  }

  "MattieTrend" should "return trend value if list has more than one element" in {
    val list: List[Double] = List(3.0, 6.0, 12.0)
    MattieTrend.calculateTrend(list) should be(Some(2.0))
  }

  "MattieTrend" should "return trend value, we're checking all of the rules." in {
    val list: List[Double] = List(0.0, 3.0, 6.0, 6, 12)
    MattieTrend.calculateTrend(list) should be(Some(3.0))
  }
  
  "MattieTrend.calculatePairs" should "return 1.0 when p1 == 0.0 and p2 > 0.0" in {
    val p1: Double = 0.0
    val p2: Double = 5.0
    MattieTrend.calculatePairs(p1, p2) should be(1.0)
  }

  "MattieTrend.calculatePairs" should "return 0.0 when p1 == p2" in {
    val p1: Double = 3.0
    val p2: Double = 3.0
    MattieTrend.calculatePairs(p1, p2) should be(0.0)
  }

  "MattieTrend.calculatePairs" should "return value for otherwise condition for pairs" in {
    val p1: Double = 3.0
    val p2: Double = 6.0
    MattieTrend.calculatePairs(p1, p2) should be(1.0)
  }
}
