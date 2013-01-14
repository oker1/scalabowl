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
          val next: Frame = rest.head
          if (next.isInstanceOf[Spare]) {
            next.asInstanceOf[Spare].firstScore
          } else if (next.isInstanceOf[Bonus]) {
            next.asInstanceOf[Bonus].bonusScore
          } else {
            next.score
          }
        } else if (current.isInstanceOf[Strike]) {
          rest.take(2).map((f: Frame) => if (f.isInstanceOf[Bonus]) {
            f.asInstanceOf[Bonus].bonusScore
          } else {
            f.score
          }).sum
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