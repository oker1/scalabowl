package bowling

/**
 * @author oker <zsolt@takacs.cc>
 */

class Bowling {
  def score(game: List[Frame]): Int = {
    val additionalScore =
      game.take(3) match {
        case Spare(_) :: tail => tail match {
          case Spare(firstScore) :: _ => firstScore
          case TwoRolls(x, y) :: _ => x
          case List(Frame(score), _*) => score
          case Nil => 0
        }
        case Strike() :: tail => tail match {
          case TwoRolls(x, y) :: _ => x + y
          case Spare(_) :: _ => 10
          case List(Frame(f1), Frame(f2)) => f1 + f2
          case List(Frame(score)) => score
          case Nil => 0
        }
        case x => 0
      }

    game match {
      case Bonus(_) :: _ => additionalScore + score(game.drop(1))
      case Frame(x) :: _ => x + additionalScore + score(game.drop(1))
      case Nil           => 0
    }
  }
}