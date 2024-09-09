object InventoryManager extends App {
  val inventory1: Map[Int, (String, Int, Double)] = Map(
    101 -> ("ProductA", 10, 15.5),
    102 -> ("ProductB", 20, 25.0),
    103 -> ("ProductC", 30, 35.5)
  )

  val inventory2: Map[Int, (String, Int, Double)] = Map(
    102 -> ("ProductB", 15, 30.0),
    104 -> ("ProductD", 50, 20.0),
    105 -> ("ProductE", 60, 45.0)
  )

  val productNames = inventory1.values.map(_._1).toList
  println(s"Product Names: $productNames")

  val totalValue = inventory1.values.map { case (_, quantity, price) => quantity * price }.sum
  println(s"Total Value of Inventory1: $totalValue")

  val isEmpty = inventory1.isEmpty
  println(s"Is Inventory1 empty? $isEmpty")

  val mergedInventory = (inventory1.keySet ++ inventory2.keySet).map { id =>
    val product1 = inventory1.get(id)
    val product2 = inventory2.get(id)
    
    val mergedProduct = (product1, product2) match {
      case (Some((name1, qty1, price1)), Some((name2, qty2, price2))) =>
        (name1, qty1 + qty2, price1 max price2)
      case (Some(product), None) => product
      case (None, Some(product)) => product
      case (None, None) => throw new IllegalStateException("This should never happen")
    }
    
    id -> mergedProduct
  }.toMap

  println(s"Merged Inventory: $mergedInventory")

  val productId = 102
  inventory1.get(productId) match {
    case Some((name, quantity, price)) =>
      println(s"Product ID $productId: Name = $name, Quantity = $quantity, Price = $price")
    case None =>
      println(s"Product with ID $productId does not exist in Inventory1")
  }
}
