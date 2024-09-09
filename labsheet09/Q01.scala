object InterestCalculator {
  def main(args: Array[String]): Unit = {
    println("Enter the deposit amount: ")
    val userInput = scala.io.StdIn.readLine()
    val interestAmount = interest(userInput.toDouble)
    println(s"The actual amount of interest is: Rs. $interestAmount")
  }

  def interest(deposit: Double): Double = {
    val interestRate: Double = deposit match {
      case d if d <= 20000     => 0.02
      case d if d <= 200000    => 0.04
      case d if d <= 2000000   => 0.035
      case _                   => 0.065
    }

    deposit * interestRate
  }
}
