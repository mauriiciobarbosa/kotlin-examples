import java.util.Date

fun main(args: Array<String>) {
    val list = 1..100000000

    val withSenquence = measureTime {
        val result = list.asSequence()
                        .filter { it % 2 == 0 }
                        .map { it * 2 }
                        .first()
        println("result with senquence is $result")
    }

    val withoutSenquence = measureTime {
        val result = list
                        .filter { it % 2 == 0 }
                        .map { it * 2 }
                        .first()
        println("result without senquence is $result")
    }    

    println("time with senquence is ${withSenquence}ms")
    println("time without senquence is ${withoutSenquence}ms")

}

inline fun measureTime(block: () -> Unit) : Long {
    val start = Date().getTime()
    block()
    val end = Date().getTime()
    return end - start
}