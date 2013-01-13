package bowling

/**
 * @author Zsolt Takacs <zsolt@takacs.cc>
 */
class Frame(val score: Int) {
  def this(first: Int, second: Int) = {
    this(first + second)
  }
  def this(first: Int, second: String) = {
    this(first)
  }
}
