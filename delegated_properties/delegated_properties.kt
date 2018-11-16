import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val foo = Foo()
    println("created foo")
    println(foo.p)
    foo.p = "teste"
    println(foo.p)
}

class Foo {
    var p: String by Delegate()
}

class Delegate {

    var value = ""

    constructor() {
        println("starting delegate...")
        value = "initial value"
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>) : String {
        println("$thisRef, thank you for delegating '${property.name}' to me!")
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.value = value
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}