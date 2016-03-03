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


//@Test
//void shouldReturnNullWhenListIsEmpty() {
//  def l = []
//
//  assert null == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnNullWhenListIsNull() {
//  def l = null
//
//  assert null == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnZeroWhenListOfOnlyOneNumber() {
//  def l = [90.0d]
//
//  assert 0.0d == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnProperPercentageWhenListOfTwoNumbersIncreasing() {
//  def l = [90.0d, 100.0d]
//
//  assert 0.1111111111111111 == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnProperPercentageWhenListOfThreeNumbersIncreasing() {
//  def l = [90.0d, 100.0d, 110.0d]
//
//  assert 0.2111111111111111 == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnProperPercentageWhenListOfThreeDifferentNumbersIncreasing() {
//  def l = [20.0d, 60.0d, 110.0d]
//
//  assert 2.8333333333333335 == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnProperPercentageWhenListOfFourDifferentNumbersIncreasing() {
//  def l = [20.0d, 60.0d, 110.0d, 150.0d]
//
//  assert 3.1969696969696972 == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnProperPercentageWhenListOfTwoNumbersDecreasing() {
//  def l = [100.0d, 90.0d]
//
//  assert -0.1 == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnProperPercentageWhenListOfThreeNumbersDecreasing() {
//  def l = [110.0d, 100.0d, 90.0d]
//
//  assert -0.19090909090909092 == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnProperPercentWhenFirstNumberIsZeroAndSecondNumberIsPositive() {
//  def l = [0.0d, 50.0d]
//
//  assert 1.0d == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnProperPercentWhenFirstNumberIsZeroAndSecondNumberIsZero() {
//  def l = [0.0d, 0.0d]
//
//  assert 0.0d == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnZeroWhenBothNumbersAreEqual() {
//  def l = [10.0d, 10.0d]
//
//  assert 0.0d == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnProperPercentWhenFirstNumberIsZero() {
//  def l = [0.0d, 50.0d, 60.0d]
//
//  assert 1.2d == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnProperPercentWhenAllZeroes() {
//  def l = [0.0d, 0.0d, 0.0d]
//
//  assert 0.0d == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldReturnProperTrendWhenFluxuationUpAndDown() {
//  def l = [10.0d, 20.0d, 10.0d]
//
//  assert 0.5d == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldHandleRealWorldExample1() {
//  def l = [2556.0d, 1160.0d, 1050.0d, 369.0d]
//
//  assert -1.2895648989723782 == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldHandleRealWorldExample2() {
//  def l = [876.0d, 920.0d, 920.0d, 920.0d]
//
//  assert 0.0502283105022831 == TrendUtils.findTrend(l)
//}
//
//@Test
//void shouldHandleRealWorldExample3() {
//  def l = [0.35530768392370576, 0.38223999999999997, 0.38223999999999997]
//
//  assert 0.07579998208560362 == TrendUtils.findTrend(l)
//}