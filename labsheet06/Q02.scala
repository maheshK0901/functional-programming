object StudentRecordApp extends App {
  def getStudentInfo(name: String, marks: Int, totalMarks: Int): (String, Int, Int, Double, Char) = {
    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
    (name, marks, totalMarks, percentage, grade)
  }

  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks: $marks/$totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty."))
    } else if (marks < 0 || totalMarks <= 0) {
      (false, Some("Marks and total marks must be positive integers."))
    } else if (marks > totalMarks) {
      (false, Some("Marks cannot exceed total possible marks."))
    } else {
      (true, None)
    }
  }

  def getStudentInfo(): (String, Int, Int, Double, Char) = {
    var isValid = false
    var errorMessage: Option[String] = None
    var name = ""
    var marks = 0
    var totalMarks = 0
    
    while (!isValid) {
      println("Enter student's name:")
      name = scala.io.StdIn.readLine()
      
      println("Enter student's marks:")
      marks = scala.io.StdIn.readInt()
      
      println("Enter total possible marks:")
      totalMarks = scala.io.StdIn.readInt()
      
      val (valid, error) = validateInput(name, marks, totalMarks)
      isValid = valid
      errorMessage = error
      
      if (!isValid) {
        println(s"Error: ${errorMessage.getOrElse("Invalid input.")}")
      }
    }
    
    getStudentInfo(name, marks, totalMarks)
  }

  val studentRecord = getStudentInfo()
  printStudentRecord(studentRecord)
}
