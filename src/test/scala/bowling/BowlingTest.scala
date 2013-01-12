package bowling

import org.scalatest._
import matchers.ShouldMatchers

/**
 * @author oker <zsolt@takacs.cc>
 */

class BowlingTest extends FlatSpec with ShouldMatchers {
  "A bowling game" should "score all misses zero" in {
    val game = new Bowling
    game.score(List(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)) should equal (0)
  }
}