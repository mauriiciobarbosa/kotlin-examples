fun main(args: Array<String>) {
    val joao = Person("João", 22, 21)
    val joaozinho = Person("João", 22)

    println("Are João and Joãozinho the same person? R - ${joao == joaozinho} ")

    joao.id.ifIsNonNull {
        println(it)
    }

    try {
        println(joao.parent)
    } catch (e: Exception) {
        println(e.message)
    }
    
}

class Person(val name: String, val age: Int, val id: Int? = null) {
    lateinit var parent: Person
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person ?: return false
        return otherPerson.name == this.name && otherPerson.age == this.age
    }
}

fun <T> T.ifIsNonNull(block: (T) -> Unit) {
    if (this != null) {
        block(this)
    }
}