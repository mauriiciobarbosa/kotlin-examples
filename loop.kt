
fun main(args: Array<String>) {
    val alphabet = 'a'..'z' // 'a' and 'z' are part of the range. (close range)
    val numbers = 1 until 100 // 100 isn't included in the range. (open range)
    val backwards = 100 downTo 1 // 100 and 1 are in the range.

    for (c in alphabet) {
        print("$c ")
    }

    println()

    for (odd in numbers step 2) {
        print("$odd ")
    }

    println()

    for (even in backwards.step(2)) {
        print("$even ")
    }

    val contains = 21 !in numbers

    println()

    print("21 ${contains.isOrIsnt} out the range")
}

val Boolean.isOrIsnt: String
    get() = if (this) "is" else "isn't"