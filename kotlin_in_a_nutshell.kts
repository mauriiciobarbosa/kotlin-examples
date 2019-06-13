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
 * conventions and delegation
  */

/**
 * lambdas, high order functions and inline functions
 */

/**
 * generics
  */


