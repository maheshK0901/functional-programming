object StringReversal {
  def reverseString(s: String): String = {
    if (s.isEmpty) ""                  
    else reverseString(s.tail) + s.head 
  }

  def main(args: Array[String]): Unit = {
    println("input a string");
    val input=scala.io.StdIn.readLine();
    val reversed = reverseString(input)
    println(s"Original: $input")
    println(s"Reversed: $reversed")
  }
}