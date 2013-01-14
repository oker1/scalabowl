package bowling

/**
 * @author oker <zsolt@takacs.cc>
 */
class Spare(val firstScore: Int) extends Frame(firstScore, 10 - firstScore) {
  def this(first: String) = {
    this(10)
  }
}
