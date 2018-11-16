import java.util.Arrays

fun main(args: Array<String>) {
    anonymousClass()
    adHocObject()
}

fun anonymousClass() {
    val list = arrayOf(2, 21, 42, 3, 8, 1, -4, 5)
    val comparator = object : Comparator<Int> {
        override fun compare(o1: Int, o2: Int): Int {
            return o1.compareTo(o2)
        }
    }
    list.sortWith(comparator)
    println(Arrays.toString(list))
}

fun adHocObject() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    print(adHoc.x + adHoc.y)
}