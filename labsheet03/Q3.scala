object ArithmeticMean {
  def average(num1: Int, num2: Int): Double = {
    val mean = (num1 + num2) / 2.0
    Math.round(mean*100.0)/100.0
  }
  def main(args: Array[String]): Unit = {
    val num1 = 20
    val num2 = 31
    val result = average(num1, num2)
    println(f"Arithmetic mean of $num1 and $num2 is: $result")
  }

}