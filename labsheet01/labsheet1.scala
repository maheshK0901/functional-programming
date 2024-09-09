import scala.math._
object Solutions {
  def main(args: Array[String]) = {
    // 1. Area of a disk with radius 5
    def areaOfDisk(radius: Double): Double = {
      Pi * radius * radius
    }
    
    val radius = 5
    val area = areaOfDisk(radius)
    println(s"The area of a disk with radius $radius is $area")

    // 2. Convert 35C to Fahrenheit
    def celsiusToFahrenheit(celsius: Double): Double = {
      celsius * 1.8 + 32
    }
    
    val celsius = 35
    val fahrenheit = celsiusToFahrenheit(celsius)
    println(s"Celsius $celsius is equal to fahrenheit $fahrenheit")

    // 3. Volume of a sphere with radius 5
    def volumeOfSphere(radius: Double): Double = {
      val pi = Math.PI
      (4.0 / 3.0) * pi * Math.pow(radius, 3)
    }
    
    val sphereRadius = 5
    val volume = volumeOfSphere(sphereRadius)
    println(s"The volume of a sphere with radius $sphereRadius is $volume")

    // 4. Total wholesale cost for 60 copies of a book
    def totalWholesaleCost(copies: Int): Double = {
      val coverPrice = 24.95
      val discount = 0.4
      val discountedPrice = coverPrice * (1 - discount)
      val shippingCost = if (copies <= 50) 3.0 else 3.0 + (copies - 50) * 0.75
      discountedPrice * copies + shippingCost
    }
    
    val copies = 60
    val totalCost = totalWholesaleCost(copies)
    println(s"The total wholesale cost for $copies copies is Rs. $totalCost")

    // 5. Total running time
    def totalRunningTime(): Int = {
      val easyPace = 8
      val tempoPace = 7
      val easyDistance = 2
      val tempoDistance = 3
      (easyPace * easyDistance * 2) + (tempoPace * tempoDistance)
    }
    
    val totalTime = totalRunningTime()
    println(s"The total running time is $totalTime minutes")
  }
}
