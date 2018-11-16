data class Person(val name: String, val age: Int)

val Boolean.yesOrNo : String
    get() = if (this) "yes" else "no"

fun main(args: Array<String>) {
    val people = listOf(Person("Mauricio", 25), 
                        Person("Adriel", 29), 
                        Person("André", 26), 
                        Person("Renato", 23),
                        Person("Joana", 30),
                        Person("João", 41),
                        Person("Karol", 20))
    
    val onlyName = people.map(Person::name)
    val youngest = people.minBy(Person::age)
    val oldest = people.maxBy(Person::age)
    val hasMoreThan25 = people.filter { it.age > 25 }
    val numberOfTwenties = people.count { it.age in 20 until 30 }
    val hasSomeoneMoreThan40 = people.any { it.age > 40 }.yesOrNo
    val everybodyIsOfAge = people.all { it.age > 18 }.yesOrNo
    val someoneWhoTheNameStartsWithJ = people.find { it.name[0] == 'J' }
    val peopleGroupedByInitial = people.groupBy { it.name.first() }
    val wordsUsedInNames = people.map { it.name.toLowerCase() }.flatMap { it.toList() }.distinct()

    println("${onlyName.size} are in the list: $onlyName")
    println("$oldest is the oldest")
    println("$youngest is the youngest")
    println("$hasMoreThan25 has more than 25")
    println("$numberOfTwenties are the twenties") 
    println("Has someone more than 40 years old? R - $hasSomeoneMoreThan40")
    println("Is everybody Of Age? R - $everybodyIsOfAge")
    println("$someoneWhoTheNameStartsWithJ is the first person who the name starts with 'J'")
    println("people grouped by initials $peopleGroupedByInitial")
    println("${wordsUsedInNames} are the words presents on name")

}