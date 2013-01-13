package bowling

import org.scalatest._
import matchers.ShouldMatchers

/**
 * @author oker <zsolt@takacs.cc>
 */

class BowlingTest extends FlatSpec with ShouldMatchers {
  "A bowling game" should "score all misses zero" in {
    val game = new Bowling
    game.score(List(new Frame(0), new Frame(0), new Frame(0), new Frame(0), new Frame(0), new Frame(0), new Frame(0), new Frame(0), new Frame(0), new Frame(0))) should equal (0)
  }
  "A bowling game" should "score all 5 game 50" in {
    val game = new Bowling
    game.score(List(new Frame(5), new Frame(5), new Frame(5), new Frame(5), new Frame(5), new Frame(5), new Frame(5), new Frame(5), new Frame(5), new Frame(5))) should equal (50)
  }
  "A bowling game" should "score a 5 and a 1 6" in {
    val game = new Bowling
    game.score(List(new Frame(5, 1))) should equal (6)
  }
  "A bowling game" should "score a 5 and a spare 10" in {
    val game = new Bowling
    game.score(List(new Frame(5, "/"))) should equal (10)
  }
  "A bowling game" should "score a 5 and a miss 5" in {
    val game = new Bowling
    game.score(List(new Frame(5, "-"))) should equal (5)
  }
  "A bowling game" should "score a strike 10" in {
    val game = new Bowling
    game.score(List(new Frame("X"))) should equal (10)
  }
  "A bowling game" should "score two misses 0" in {
    val game = new Bowling
    game.score(List(new Frame("-", "-"))) should equal (0)
  }
  "A bowling game" should "score a miss and a spare 10" in {
    val game = new Bowling
    game.score(List(new Frame("-", "/"))) should equal (10)
  }
  "A bowling game" should "score a miss and a 1 1" in {
    val game = new Bowling
    game.score(List(new Frame("-", 1))) should equal (1)
  }
}