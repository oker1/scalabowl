package bowling

/**
 * @author oker <zsolt@takacs.cc>
 */

class Bowling {
  def score(game: List[Frame]): Int = {
    val additionalScore =
      game.take(3) match {
        case Spare(_) :: Spare(firstScore) :: _     => firstScore
        case Spare(_) :: TwoRolls(x, y) :: _        => x
        case Spare(_) :: List(Frame(score), _*)     => score
        case Strike() :: TwoRolls(x, y) :: _        => x + y
        case Strike() :: Spare(_) :: _              => 10
        case Strike() :: List(Frame(f1), Frame(f2)) => f1 + f2
        case Strike() :: List(Frame(score))         => score
        case x                                      => 0
      }

    game match {
      case Bonus(_) :: tail => additionalScore + score(tail)
      case Frame(x) :: tail => x + additionalScore + score(tail)
      case Nil              => 0
    }
  }
}