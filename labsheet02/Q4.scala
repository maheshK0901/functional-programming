object Ticket{
    def attendees(price: Int): Int = 120+(15-price)/5*20

    def revenue(price : Int): Int = attendees(price)*price

    def cost(price: Int): Int = 500+attendees(price)

    def profit(price: Int): Int = revenue(price) - cost(price)

    def main(args: Array[String]): Unit = {
        print(profit(5),profit(10),profit(15),profit(25),profit(35),profit(40))
    }
}