object StringFilter {
  def filterStrings(strings: List[String]): List[String] = {
    strings.filter(_.length > 5)
  }

  def main(args: Array[String]): Unit = {
    val input = List("mahesh", "often", "help", "bro", "mother")
    val filtered = filterStrings(input)
    println(s"Original list: $input")
    println(s"Filtered list: $filtered")
  }
}