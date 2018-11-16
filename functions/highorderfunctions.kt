fun main(args: Array<String>) {
    val sum: (Int, Int) -> Int = {x, y -> x + y}
    val action = { println(42) }
    println(sum(4,5))
    action()

    twoAndThree {
        a, b -> a + b
    }

    println("mauricio".filter {
        it in 'a'..'o'
    })


    val contacts = listOf(Person("Dmitry", "Jeremov", "123-4567"),
                          Person("Svetlana", "Isakova", null))

    val contactListFilters = ContactListFilters().apply {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }

    println(contacts.filter(contactListFilters.getPredicate()))

}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()

    this.forEach {
        if (predicate(it)) sb.append(it)
    }

    return sb.toString()
}

inline fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
} 

data class Person(val firstName: String,
                  val lastName: String,
                  val phoneNumber: String?)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        val startWithPrefix = {
            p: Person -> 
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }

        if (onlyWithPhoneNumber) {
            return { startWithPrefix(it) && it.phoneNumber != null }
        }

        return startWithPrefix
    }

}