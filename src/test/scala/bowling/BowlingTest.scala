package bowling

import org.scalatest._
import matchers.ShouldMatchers

/**
 * @author oker <zsolt@takacs.cc>
 */

class BowlingTest extends FlatSpec with ShouldMatchers with BeforeAndAfterEach {
  var game: Bowling = _

  "A bowling game"  should "score all misses zero" in {
    game.score(List(
      new TwoRolls(0, 0), new TwoRolls(0, 0), new TwoRolls(0, 0), new TwoRolls(0, 0), new TwoRolls(0, 0),
      new TwoRolls(0, 0),new TwoRolls(0, 0), new TwoRolls(0, 0), new TwoRolls(0, 0), new TwoRolls(0, 0)
    )) should equal (0)
  }
  it should "score a 5 and a 1 6" in {
    game.score(List(new TwoRolls(5, 1))) should equal (6)
  }
  it should "score a 5 and a spare 10" in {
    game.score(List(new Spare(5))) should equal (10)
  }
  it should "score a 5 and a miss 5" in {
    game.score(List(new TwoRolls(5, "-"))) should equal (5)
  }
  it should "score a strike 10" in {
    game.score(List(new Strike)) should equal (10)
  }
  it should "score two misses 0" in {
    game.score(List(new Miss())) should equal (0)
  }
  it should "score a miss and a spare 10" in {
    game.score(List(new Spare("-"))) should equal (10)
  }
  it should "score a miss and a 1 1" in {
    game.score(List(new TwoRolls(0, 1))) should equal (1)
  }
  it should "score a 5 and a spare and a 3 16" in {
    game.score(List(new Spare(5), new TwoRolls(3, 0))) should equal (16)
  }
  it should "score a strike and a 5 and a miss 20" in {
    game.score(List(new Strike(), new TwoRolls(5, 0))) should equal (20)
  }
  it should "score three strikes 60" in {
    game.score(List(new Strike(), new Strike(), new Strike())) should equal (60)
  }
  it should "score a perfect game 300" in {
    game.score(List(
      new Strike(), new Strike(), new Strike(), new Strike(), new Strike(),
      new Strike(), new Strike(), new Strike(), new Strike(), new Strike(), new Bonus(10), new Bonus(10)
    )) should equal (300)
  }
  it should "score an all 5 spare game 150" in {
    game.score(List(
      new Spare(5), new Spare(5), new Spare(5), new Spare(5), new Spare(5),
      new Spare(5), new Spare(5), new Spare(5), new Spare(5), new Spare(5), new Bonus(5)
    )) should equal (150)
  }

  override def beforeEach() {
    game = new Bowling
  }
}