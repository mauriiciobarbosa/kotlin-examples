import java.beans.PropertyChangeSupport
import java.beans.PropertyChangeListener
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val data = mutableMapOf("company" to "Capgemini", "status" to "married")
    val p = Person("Dmitry", 34, 2000, data)

    p.addPropertyChangeListener(PropertyChangeListener {
        event -> println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
    })

    p.age = 35
    p.salary = 2100

    println(p)
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class ObservableProperty<T>(var propValue: T, 
                            val changeSupport: PropertyChangeSupport) {

    operator fun getValue(p: Person, prop: KProperty<*>) = propValue

    operator fun setValue(p: Person, prop: KProperty<*>, newValue: T) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

}

class Person(val name: String, age: Int, salary: Int,
             val attributes: Map<String, String>): PropertyChangeAware() {
    var age: Int by ObservableProperty(age, changeSupport)
    var salary: Int by ObservableProperty(salary, changeSupport)
    val company: String by attributes
    val status: String by attributes

    override fun toString() : String {
        return "Person(name = $name, age = $age, salary = $salary, company = $company, status = $status)"
    }
}