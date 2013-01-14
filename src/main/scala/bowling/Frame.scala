package bowling

/**
 * @author Zsolt Takacs <zsolt@takacs.cc>
 */
class Frame(val first: Int, second: Int) {
  val score = first + second

  def this(first: Int, second: String) = {
    this(first, 0)
  }
}
