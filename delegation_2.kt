fun main(args: Array<String>) {
    val button = ClickButtonCounter()
    button.describe()
    button.click()
    button.showOff()
}

interface View {
    fun describe()
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable")
}

interface Focusable {
    fun showOff() = println("I'm Focusable")
}

open class Button(var state: Boolean = false): Clickable, Focusable, View {
    override fun describe() = println("Hi I'm a button")
    override fun click() = println("I was clicked.")
    override fun showOff() = if (state) super<Focusable>.showOff() else super<Clickable>.showOff() 

}

class RoundedButton() : Button() {
    override fun describe() = println("Hi I'm a rounded button")
}

class ClickButtonCounter(val innerButton: Button = RoundedButton()) : Clickable, Focusable, View by innerButton {
    var counter: Int = 0 
        private set

    override fun showOff() = innerButton.showOff()

    override fun click() {
        counter++
        innerButton.click()
    }
}