fun main(args: Array<String>) {
    println(oneHalf(3))
    println(max("Java", "Kotlin"))
    reifieds()
    covariant()
    contravariant()
    useSiteVariance()
    starProjection()
}

fun reifieds() {
    println(isA<String>("abc"))
    println(isA<String>(123))
}

fun covariant() {
    val cats = Herd(listOf(Cat("tico"), Cat("mia"), Cat("dollar")))
    feedAll(cats)
}

fun contravariant() {
    val anyComparator = Comparator<Any> {
        e1, e2 -> e1.hashCode() - e2.hashCode()
    }

    val names = listOf("Joao", "Maria", "Jose")
    println(names.sortedWith(anyComparator))
}

fun useSiteVariance() {
    val names = listOf("Joao", "Maria", "Jose")
    val list = mutableListOf<CharSequence>() 
    copyData(names, list)
    println(list)
}

fun starProjection() {
    printFirst(listOf("Joao", "Maria", "Jose"))
    printFirst(listOf(1, 5, 12))
    printFirst(listOf('C', null, 12))
}

fun <T: Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

fun <C: Comparable<C>> max(first: C, second: C): C {
    return if (first > second) first else second
}

inline fun <reified T> isA(value: Any) = value is T

fun feedAll(animals: Herd<Animal>) {
    for (index in 0 until animals.size) {
        animals[index].feed()
    }
}

open class Animal(val name: String) {
    fun feed() = println("feeding $name")
}

class Cat(name: String): Animal(name) {
    fun cleanLitter() = println("cleaning $name")
}

class Herd<out T: Animal>(val animals: List<T>) {
    val size: Int get() = animals.size
    operator fun get(index: Int): T = animals[index]
}

fun <T> copyData(source: List<T>, destination: MutableList<in T>) {
    source.forEach {
        element -> destination.add(element)
    }
}

fun printFirst(list: List<*>) {
    if (list.isNotEmpty()) {
        println(list.first())
    }
}