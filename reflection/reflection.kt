fun main(args: Array<String>) {
    accessKclassFromObject(Person("Alice", 35))
    accessKcalable()
    accessKproperty()
    accessMemberProperty()
}

fun accessKclassFromObject(person: Person) {
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach { 
        println(it.name)
    }
}

fun accessKcalable() {
    val kFunction = ::foo
    kFunction.call(42)
}

fun accessKproperty() {
    var counter = 0
    val kProperty = ::counter
    kProperty.setter.call(21)
    println(kProperty.get())
}

fun accessMemberProperty() {
    val person = Person("Alice", 29)
    val memberProperty = Person::age
    println(memberProperty.get(person))
}

fun foo(x: Int) = println(x)

class Person(val name: String, val age: Int)