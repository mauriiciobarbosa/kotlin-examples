fun main(args: Array<String>) {
    val nested = Outer.Nested()
    val inner = Outer().Inner()
    nested.foo()
    inner.foo()
}

class Outer(private val bar: Int = 1) {
    class Nested { // I'm not able to access Outer class' members. =(
        fun foo() = println(2)
    }

    inner class Inner {
        fun foo() = println(bar)
    }
}