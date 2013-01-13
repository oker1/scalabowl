package bowling

/**
 * @author oker <zsolt@takacs.cc>
 */

class Bowling {
  def score(game: List[Frame]): Int = {
    if (game.isEmpty) {
      0
    } else {
      val current = game.head
      val rest = game.drop(1)

      val additionalScore = if (rest.nonEmpty) {
        if (current.isInstanceOf[Spare]) {
          10 - current.asInstanceOf[Spare].firstScore
        } else if (current.isInstanceOf[Strike]) {
          score(rest.take(2))
        } else {
          0
        }
      } else {
        0
      }


      current.score + additionalScore + score(rest)
    }
  }
}