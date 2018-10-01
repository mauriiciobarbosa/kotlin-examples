fun main(args: Array<String>) {
    val duck = MallardDuck()
    duck.display()
    duck.fly()
    duck.quack()
    duck.swim()
}

abstract class Duck(var flyBehavior: FlyBehavior,
                    var quackBehavior: QuackBehavior): FlyBehavior by flyBehavior, QuackBehavior by quackBehavior  {

    abstract fun display()

    fun swim() = println("All ducks float, even decoys!")
}

class MallardDuck(): Duck(FlyWithWings, Quack) {
    override fun display() = println("I'm a mallard duck")
}

interface FlyBehavior {
    fun fly()
}

object FlyWithWings: FlyBehavior {
    override fun fly() = println("I'm flying")
}

object FlyNoWay: FlyBehavior {
    override fun fly() = println("I can't fly")
}

interface QuackBehavior {
    fun quack()
}

object Quack: QuackBehavior {
    override fun quack() = println("Quack")
}

object MuteQuack: QuackBehavior {
    override fun quack() = println("Silence")
}

object Squeak: QuackBehavior {
    override fun quack() = println("squeak")
}