fun main(args: Array<String>) {
    val sum :(Int, Int) -> Int = { x, y -> x + y }
    val action = { println(42) }
    println(sum(3, 4))
    action()
   
    twoAndThree {
        a, b -> a * b
    }
    
    println("ab1c".filter {it in 'a'..'z'})

    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${calculator(Order(3))}")
}

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    this.forEach {
        if (predicate(it)) sb.append(it)
    }
    return sb.toString()
}

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    return when(delivery) {
        Delivery.EXPEDITED -> { order -> 6 + 2.1 * order.itemCount }
        Delivery.STANDARD -> { order -> 1.2 * order.itemCount }
        // else -> throw RuntimeException("invalid delivery $delivery")
    }
}