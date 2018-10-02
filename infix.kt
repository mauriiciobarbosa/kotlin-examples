fun main(args: Array<String>) {
    val list = mutableListOf('a', 'b', 'c', 'd', 'z')
    
    println(list)
    list kill 'b'
    
    println(list)
    list kill 'h'

    println(list)
    list kill 'z'

    println(list)
}

infix fun <T> MutableList<T>.kill(value: T) {
    if (value in this) {
        this.remove(value)
    }
}