fun main() {
    val cells = listOf(
        "Month" to "Savings",
        "January" to "R$300,00",
        "February" to "R$500,00",
        "March" to "-R$200,00"
    )
    val myTable = table {
        for ((index, cell) in cells.withIndex()) {
            val (month, saving) = cell
            val color = if (saving.startsWith('-')) "red" else "blue"

            tr {
                if (index == 0) {
                    th(month)
                    th(saving)
                } else {
                    td { content(month) }
                    td {
                        content(saving)
                        bgColor(color)
                    }  
                }
            }
        }
    }
    println(myTable)
}

fun table(block: TABLE.() -> Unit): TAG {
    val table = TABLE() 
    table.block()
    return table
}

interface TAG

class TABLE : TAG {
    val children = mutableListOf<TR>()

    fun tr(block: TR.() -> Unit) {
        val tr = TR()
        children += tr
        tr.block()
    }

    override fun toString() = buildString {
        append("<table>\n")
        children.forEach {
            append(it)
        }
        append("</table>")
    }
}

class TR : TAG {
    val ths = mutableListOf<TH>()
    val tds = mutableListOf<TD>()

    fun td(block: TD.() -> Unit) {
        if (ths.isNotEmpty()) return
        val td = TD()
        tds += td
        td.block()
    }

    fun th(content: String) {
        if (tds.isNotEmpty()) return
        val th = TH(content)
        ths += th
    }

    override fun toString() = buildString {
        append("<tr>\n".pad(4))
        ths.forEach {
            append(it)
        }
        tds.forEach {
            append(it)
        }
        append("</tr>\n".pad(4))
    }
}

class TH(private val content: String) : TAG {
    override fun toString(): String {
        return "<th bgcolor=\"black\">$content</th>\n".pad(8)
    }
}

class TD(
    private var bgColor: String = "",
    private var content: String = ""
) : TAG {

    fun content(content: String) {
        this.content = content
    }

    fun bgColor(color: String) {
        bgColor = color
    }

    override fun toString(): String {
        if (bgColor.isNotEmpty()) return "<td bgcolor=\"$bgColor\">$content</td>\n".pad(8)
        return "<td>$content</td>\n".pad(8)
    }
}

fun String.pad(number: Int) : String {
    var pad = ""
    for (i in 0 until number) pad += ' '
    return pad + this
}