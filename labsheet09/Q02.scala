object NumberClassifier {
  def main(args: Array[String]): Unit = {
    println("Enter an integer: ")
    val input = scala.io.StdIn.readInt()

    val classifyNumber: Int => String = {
      case n if n <= 0 => "Negative/Zero"
      case n if n % 2 == 0 => "Even number"
      case _ => "Odd number"
    }

    println(classifyNumber(input))
  }
}
