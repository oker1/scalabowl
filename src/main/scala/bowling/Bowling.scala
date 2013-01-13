package bowling

/**
 * @author oker <zsolt@takacs.cc>
 */

class Bowling {
  def score(game: List[Frame]) = {
    game.map(_.score).sum
  }
}