import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@ExperimentalContracts
fun main(args: Array<String>) {
    tryAsADog(Dog("jhonny"))
    tryAsADog(Cat("James"))
}

@ExperimentalContracts
fun tryAsADog(animal: Animal?) {
    if (animal.isADog()) {
        animal.describe()
        animal.bark()
    }
}

@ExperimentalContracts
fun Animal?.isADog(): Boolean {
    contract {
        returns(true) implies (this@isADog is Dog)
    }
    return this != null && this is Dog
}

interface Animal {
    fun describe()
}

class Dog(val name: String): Animal {
    override fun describe() {
        println("I'm a dog")
    }

    fun bark() {
        println("au au au au")
    }
}

class Cat(val name: String): Animal {
    override fun describe() {
        println("I'm a cat")
    }
}