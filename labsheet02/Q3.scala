object Company {
    def normal(h: Double): Double = {
        250 * h
    }

    def OT(h: Double): Double = {
        85 * h
    }

    def tax(income: Double): Double = {
        0.12 * income
    }

    def main(args: Array[String]): Unit = {
        val normalHours = 40.0
        val otHours = 30.0

        val income = normal(normalHours) + OT(otHours)
        val finalSalary = income - tax(income)
        println(s"The final salary is Rs. ${finalSalary}")
    }
}