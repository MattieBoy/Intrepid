import com.example.MattieUrinal
import org.scalatest._

class MattieUrinalSpec extends FlatSpec with Matchers {
  
  "MattieUrinal.restroom" should "have at least two urinals" in {
    val urinals = Map("urinal1" -> false, "urinal2" -> false, "urinal3" -> false, "urinal4" -> false)
    MattieUrinal.chooseUrinal(urinals).size should be >= 2
  }

  "MattieUrinal" should "choose farthest urinal if open and adjacent urinal is open" in {
    val actualUrinals = Map("urinal1" -> false, "urinal2" -> false, "urinal3" -> false, "urinal4" -> false)
    val expectedUrinals = Map("urinal1" -> false, "urinal2" -> false, "urinal3" -> false, "urinal4" -> true)
    MattieUrinal.chooseUrinal(expectedUrinals) should equal(actualUrinals)
  }
  
}
