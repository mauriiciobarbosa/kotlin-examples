import java.lang.Math.abs

var p1 = Point(10, 20)
var p2 = Point(30, 40)
var p3 = Point(2, 4)

fun main(args: Array<String>) {

    // arithmeticOperators()
    // compoundAssigmentOperator()
    // unaryOperators()
    comparisonOperators()

}

fun arithmeticOperators() {
    println(p1 + p2)
    println(p1 + p2 * p3)
    println(p1 * 1.5)
    println(2.1 * p1)

    println('a' * 3)
}

fun comparisonOperators() {
    println("p1 != p2 => ${p1 != p2}")
    println("p3 == Point(2, 4) => ${p3 == Point(2, 4)}")
}

fun unaryOperators() {
    println(-p1)
    println(++p1)
}

fun compoundAssigmentOperator() {
    p1 -= p3
    println(p1)

    val author = Author("Mauricio")
    val createBook = Author::Book
    author += createBook("A origem do universo")
    author += createBook("Era uma vez")

    println(author)

    val list = arrayListOf(1, 2)
    list += 3 // change "list"
    val newList = list + listOf(4, 5) // returns a new list containing all the elements
    
    println(list)
    println(list + 4)
    println(newList)
}

data class Author(val name: String, 
                  val books: MutableList<Book> = mutableListOf()){

    operator fun plusAssign(book: Book) {
        books += book;
    }

    class Book(val name: String) {
        override fun toString() = name
    }
}

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(other.x + x, other.y + y)
    operator fun times(other: Point) = Point(other.x * x, other.y * y)
    operator fun minus(other: Point) = Point(abs(other.x - x), abs(other.y - y))
    operator fun unaryMinus() = copy(x = -x, y = -y)
    operator fun inc() = copy(x = x + 1, y = y + 1)
}

/* 
 * Defining an operator with different operand types
 */
operator fun Point.times(scale: Double) = copy(x = (x * scale).toInt(), y = (y * scale).toInt()) 

/*
 * Kotlin operator don't automatically support commutativity
 */
operator fun Double.times(p: Point) = p * this

/* 
 * Defining an operator with different result type
 */
operator fun Char.times(count: Int) = toString().repeat(count)