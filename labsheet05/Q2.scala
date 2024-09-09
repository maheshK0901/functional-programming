import scala.collection.mutable.Set

object LibraryManagementSystem {

  case class Book(title: String, author: String, isbn: String)

  var library: Set[Book] = Set(
    Book("Andare", "V.D.D.Lanorol", "9789552100526"),
    Book("Magul Kema", "Kumarathunga Munidasa", "9552101069"),
    Book("Gamperaliya", "Martin Wickramasinghe", "9556950060")
  )

    //Function to add a book
  def addBook(book: Book): Unit = {
    if (!isBookInLibrary(book.isbn)) {
      library += book
      println(s"\n'${book.title}' by ${book.author} added to the library.")
    } else {
      println(s"\nBook with ISBN '${book.isbn}' already exists in the library.")
    }
  }

  // Function to remove a book from the library by its ISBN
  def removeBook(isbn: String): Unit = {
    library.find(_.isbn == isbn) match {
      case Some(book) =>
        library -= book
        println(s"\n'${book.title}' by ${book.author} removed from the library.\n")
      case None =>
        println(s"\nNo book with ISBN $isbn found in the library.\n")
    }
  }

  // Function to check if a book is in the library by its ISBN
  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  // Function to display the current library collection
  def displayLibrary(): Unit = {
    println("\nCurrent Library Collection:")
    library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
  }

  // Function to search for a book by its title
  def searchBookByTitle(title: String): Unit = {
    library.find(_.title.equalsIgnoreCase(title)) match {
      case Some(book) =>
        println(s"\nBook found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"\nNo book with title '$title' found in the library.")
    }
  }

  // Function to display all books by a specific author
  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"\nBooks by $author:")
      booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    } else {
      println(s"\nNo books by $author found in the library.")
    }
  }

  def main(args: Array[String]): Unit = {
    displayLibrary()

    // Add a new book
    addBook(Book("Hath Pana", "Kumarathunga Munidasa", "9789552104763"))

    // Remove a book by ISBN
    removeBook("9556950060")
    removeBook("9732567188")

    // Check if a book is in the library by ISBN
    println(s"Is book with ISBN 9552101069 in the library? ${isBookInLibrary("9552101069")}")

    // Display the updated library collection
    displayLibrary()

    // Search for a book by title
    searchBookByTitle("Andare")

    // Display all books by a specific author
    displayBooksByAuthor("Kumarathunga Munidasa")
  }
}
