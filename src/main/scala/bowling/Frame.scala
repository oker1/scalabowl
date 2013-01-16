package bowling

/**
 * @author Zsolt Takacs <zsolt@takacs.cc>
 */
sealed abstract class Frame(val score: Int)
object Frame {
  def unapply(a: Frame) = Some(a.score)
}

case class Miss() extends Frame(0)
case class Bonus(bonusScore: Int) extends Frame(0)
case class Strike() extends Frame(10)
case class TwoRolls(first: Int, second: Int) extends Frame(first + second) {
  def this(first: Int, second: String) = {
    this(first, 0)
  }
}
case class Spare(firstScore: Int) extends Frame(10) {
  def this(first: String) = {
    this(10)
  }
}