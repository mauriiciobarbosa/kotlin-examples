import kotlin.random.Random

/**
 * Function declarations
 */

// Hello world (implicit return value)

// Random Int example (default values, named parameters, expression body)

/**
 * control structures
 */

// Max value example (if expression)

// Color example (when expression)

enum class Color {
    RED, BLUE, YELLOW
}

// Print numbers example (for statement)

// even number example (progression)

/**
 * Range
 */

// even number example improved


// the alphabet example

// ia a digit example

/**
 * variables and nullability
 */

// Question and operation status examples

// say my name example (String templates)


/**
 * Class and data class
 */

// Person example

//val p1 = Person("Mauricio Barbosa", 26, isMarried = false)
//val p2 = Person(fullName = "Mauricio Barbosa", age = 26)

/**
 * extensions functions and properties
 */

// is a digit example

// last name example

/**
 * Operator overloading
 */

// Point example (arithmetic operators)
data class Point(val x: Int, val y: Int)

var point1 = Point(1, 5)
val point2 = Point(5, 1)

val point3 = Point(x = point1.x + point2.x, y = point1.y + point2.y)
//val point3 = point1 + point2
//val point4 = point1 - point2
//val point5 = ++point1

point3.toString()
//point4.toString()
//point5.toString()

// Rectangle example (contains operator)
data class Rectangle(val upperLeft: Point, val lowerRight: Point)

val r = Rectangle(point1, point2)

//point3 in r
//Point(4, 4) in r

/**
 * Collections and lambdas
 */

//val fenix = listOf(
//    Person("Mauricio Barbosa", 26),
//    Person("Paulo Fertonani", 30),
//    Person("Rafael Quixabeira", 29),
//    Person("Fábio Gomide", 40, true),
//    Person("Gustavo perna de pau", 30, true)
//)

// Older, younger and marrieds  (lambdas and method reference)

// People grouped by initial

// Words used on names

/**
 * high order functions
 */

// random operation example

//val oper1 = randomOperation()
//val oper2 = randomOperation()
//
//oper1(1, 2)
//oper2(1, 2)


/**
 * Delegation
 */

// Database example (lazy delegation)
class Database

// fund details example (map delegation)

val details = mapOf(
    "grossValue" to 12280.79,
    "netValue" to 12280.79,
    "ir" to 0.0,
    "tax" to 2.0,
    "liquidation" to 31
)

class FundDetails(map: Map<String, Any>)

val fund = FundDetails(details)

// Beverage example (class delegation)

interface Beverage {
    val price: Double
    val description: String
}

class Beer(
    override val price: Double = 12.9,
    override val description: String = "I'm a beer"
) : Beverage

val beer = Beer()

beer.price
