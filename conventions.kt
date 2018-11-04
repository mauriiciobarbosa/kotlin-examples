import java.lang.Math.abs

val createBook = Author::Book

var p1 = Point(10, 20)
var p2 = Point(30, 40)
var p3 = Point(2, 4)
var a1 = Author("Mauricio", mutableListOf(createBook("A origem do universo"), createBook("Era uma vez")))
var a2 = Author("Mauro", mutableListOf(createBook("Pare de acreditar no governo")))

fun main(args: Array<String>) {

    arithmeticOperators()
    compoundAssigmentOperator()
    unaryOperators()
    comparisonOperators()
    collectionAndArrangeOperators()
    destructureConvention()

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
    println("${a1.name} > ${a2.name} = ${a1 > a2}")
}

fun unaryOperators() {
    println(-p1)
    println(++p1)
}

fun compoundAssigmentOperator() {
    p1 -= p3
    println(p1)

    val author = Author("Mauricio")
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

fun collectionAndArrangeOperators() {
    println("coordinates for p1 => {x = ${p1[0]}, y = ${p1[1]}, z = ${p1[2]}}")
    p1[2] = 30
    println("coordinates for p1 => {x = ${p1[0]}, y = ${p1[1]}, z = ${p1[2]}}")

    val rect = Rectangle(p1, p2)
    println("Point(15, 30) is in $rect = ${Point(15, 30) in rect}")
    println("Point(2, 2) is in $rect = ${Point(2, 2) in rect}")
}

fun destructureConvention() {
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")

    for ((key, value) in map) {
        println("$key -> $value")
    }
}

data class Author(val name: String, 
                  val books: MutableList<Book> = mutableListOf()) : Comparable<Author> {

    operator fun plusAssign(book: Book) {
        books += book;
    }

    override fun compareTo(other: Author) : Int {
        return compareValuesBy(this, other, Author::name, {
            author -> author.books.size
        })
    }

    class Book(val name: String) {
        override fun toString() = name
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

data class Point(val x: Int, val y: Int, var z: Int = 0) {
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

/*
 * Implementing the get convention
 */
operator fun Point.get(position: Int) = when(position) {
    0 -> x
    1 -> y
    2 -> z
    else -> throw IndexOutOfBoundsException("Invalid coordinate $position")
}

/*
 * Implementing the set convention
 */
operator fun Point.set(position: Int, value: Int) = when(position) {
    0, 1 -> throw UnsupportedOperationException("Isn't possible change value of coordinates x and y")
    2 -> z = value
    else -> throw IndexOutOfBoundsException("Invalid coordinate $position")
}

operator fun Rectangle.contains(p: Point) : Boolean {
    return p.x in upperLeft.x until lowerRight.x &&
           p.y in upperLeft.y until lowerRight.y
}