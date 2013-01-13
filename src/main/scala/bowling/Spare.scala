package bowling

/**
 * @author oker <zsolt@takacs.cc>
 */
class Spare(val firstScore: Int) extends Frame(10) {
  def this(first: String) = {
    this(10)
  }
}
