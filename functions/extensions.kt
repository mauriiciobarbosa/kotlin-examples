fun main(args: Array<String>) {
    val list = listOf("João", "Maria", "José", "Katarina", "Natália")
    val personList = listOf(Person("João", 21), Person("Maria", 32), Person("José", 11))
    val max: Any? = list.max{ it.length }
    println("the max value from $list is $max")
    val maxAgeFunction = Person::age
    val maxAge = personList.max(maxAgeFunction)
    println("the max value from $personList is $maxAge")
}

data class Person(val name: String, val age: Int)

inline fun <T> List<T>.max(selector: (T) -> Int) : T? {
    var max: T? = null
    var maxValue: Int = 0

    this.forEach {
        val value = selector(it)

        if (value > maxValue) {
            max = it
            maxValue = value
        }
    }

    return max
}