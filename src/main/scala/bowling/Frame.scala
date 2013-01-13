package bowling

/**
 * @author Zsolt Takacs <zsolt@takacs.cc>
 */
class Frame(val score: Int) {
  def this(first: Int, second: Int) = {
    this(first + second)
  }
  def this(first: Int, second: String) = {
    this(if (second == "/") 10 else first)
  }
  def this(first: String) = {
    this(if (first == "X") 10 else 0)
  }
  def this(first: String, second: String) = {
    this {
      if (first == "-" && second == "-") {
        0
      } else if (second == "/") {
        10
      } else 0
    }
  }
  def this(first: String, second: Int) = {
    this(if (first == "-") second else 0)
  }
}
