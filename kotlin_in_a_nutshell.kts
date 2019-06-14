import kotlin.random.Random

/**
 * Function declarations
 */

// Hello world (implicit return value)
fun printHello(): Unit {
    println("hello, world!")
}

printHello()

// Random Int example (default values, named parameters, expression body)

fun randomInt(minValue: Int, maxValue: Int = 100) = Random.nextInt(minValue, maxValue)

randomInt(0, 100)
randomInt(50)
randomInt(minValue = 15, maxValue = 80)
randomInt(maxValue = 55, minValue = 51)

/**
 * control structures
 */

// Max value example (if expression)

fun maxValue(a: Double, b: Double): Double {
    return if (a > b) {
        a
    } else {
        b
    }
}

maxValue(1.5, 1.8)

// Color example (when expression)

enum class Color {
    RED, BLUE, YELLOW
}

fun getColorName(color: Color): String {
    return when (color) {
        Color.RED -> "red"
        Color.BLUE -> "blue"
        Color.YELLOW -> "yellow"
    }
}

getColorName(Color.BLUE)

// Print numbers example (for statement)

fun sum(n: Int): Int {
    var sum = 0
    for (i in 1 until n) {
        sum += i
    }
    return sum
}

sum(100)

// even number example (progression)

fun nEvens(n: Int): Int {
    var sum = 0
    for (i in 2..n step 2) {
        sum += i
    }
    return sum
}

nEvens(100)

/**
 * Range
 */

// even number example improved

fun nEvensImproved(n: Int) = (2..n step 2).sum()

nEvensImproved(100)

// the alphabet example

('a'..'z').toList()

// ia a digit example

fun isADigit(char: Char): Boolean = char in '0'..'9'

isADigit('9')
isADigit('c')

/**
 * variables and nullability
 */

// Question and operation status examples

val question: String = "Is Kotlin awesome?"
var answer: String? = "Yes, it's!"
answer = "no, it's not!"
answer = null
//answer = 42

fun getOperationStatus(canPerformOperation: Boolean = false): String {
    val status: String

    if (canPerformOperation) {
        status = "Success"
    } else {
        status = "Failed"
    }

    return status
}

getOperationStatus(true)

// say my name example (String templates)

fun sayMyName(name: String) = "You're ${name.capitalize()}"

sayMyName("mauricio")

/**
 * Class and data class
 */

// Person example

data class Person(val fullName: String, val age: Int, val isMarried: Boolean = false)

val p1 = Person("Mauricio Barbosa", 26)
val p2 = Person(fullName = "Mauricio Barbosa", age = 26)

p1.toString()

p1 == p2

val p3 = p1.copy(isMarried = true)

p2 == p3

/**
 * extensions functions and properties
 */

// is a digit example

fun Char.isDigit() = this in '0'..'9'

'9'.isDigit()
'b'.isDigit()

// last name example

val Person.lastName: String
    get() = fullName.split(" ").last()

p1.lastName

/**
 * Operator overloading
 */

// Point example (arithmetic operators)
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point) = Point(x = x + other.x, y = y + other.y)
    operator fun minus(other: Point) = Point(x = x - other.x, y = y - other.y)
    operator fun inc() = Point(x + 1, y + 1)
}

var point1 = Point(1, 5)
val point2 = Point(5, 1)

val point3 = point1 + point2
val point4 = point1 - point2
val point5 = ++point1
//val point3 = Point(x = point1.x + point2.x, y = point1.y + point2.y)

point3.toString()
point4.toString()
point5.toString()

// Rectangle example (contains operator)
data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x &&
        p.y in lowerRight.y until upperLeft.y
}

val r = Rectangle(point1, point2)

point3 in r
Point(4, 4) in r

/**
 * Collections and lambdas
 */

val fenix = listOf(
    Person("Mauricio Barbosa", 26),
    Person("Paulo Fertonani", 30),
    Person("Rafael Quixabeira", 29),
    Person("Fábio Gomide", 40, true),
    Person("Gustavo perna de pau", 30, true)
)

// Older, younger and single  (lambdas and method reference)

fenix.maxBy { p -> p.age }
fenix.minBy { it.age  }
"Gamer over: ${fenix.filter(Person::isMarried).map { it.fullName }}"

// People grouped by initial
fenix.groupBy { it.fullName.first() }

// Words used on names

fenix.map { it.fullName.toLowerCase()}
    .flatMap { it.toList() }
    .distinct()
    .filter { it != ' ' }
    .sorted()

/**
 * high order functions
 */

// random operation example

fun randomOperation(): (Int, Int) -> Int {
    val index = Random.nextInt(1, 4)
    return when (index) {
        1 -> { a, b -> a + b }
        2 -> { a, b -> a - b }
        3 -> { a, b -> a * b }
        else -> { a, b -> a / b }
    }
}

val oper1 = randomOperation()
val oper2 = randomOperation()

oper1(1, 2)
oper2(1, 2)


/**
 * Delegation
 */

// Database example (lazy delegation)

class Database {
    init {
        print("initializing...")
    }

    fun query(select: String) = print("querying $select")
}

val database by lazy { Database() }

database.query("something")
database.query("something else")

// fund details example (map delegation)

val details = mapOf(
    "grossValue" to 12280.79,
    "netValue" to 12280.79,
    "ir" to 0.0,
    "tax" to 2.0,
    "liquidation" to 31
)

class FundDetails(map: Map<String, Any>) {
    val grossValue: Double by map
    val netValue: Double by map
    val ir: Double by map
    val tax: Double by map
    val liquidation: Int by map
}

val fund = FundDetails(details)

fund.ir
fund.liquidation

// class delegation

interface Beverage {
    val price: Double
    val description: String
}

class Beer(
    override val price: Double = 12.9,
    override val description: String = "I'm a beer"
) : Beverage

class DoubleBeer(private val beer: Beer = Beer()): Beverage by beer {
    override val price: Double
        get() = beer.price * 1.5
}

val beer = DoubleBeer()

beer.price
