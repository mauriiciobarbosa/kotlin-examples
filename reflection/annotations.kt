import kotlin.reflect.full.memberProperties
fun main(args: Array<String>) {
    
}

data class Person(
    @JsonName("alias") val name: String = "no-name", 
    @JsonExclude val age: Int? = 0
)

@Target(AnnotationTarget.PROPERTY)
annotation class JsonExclude

@Target(AnnotationTarget.PROPERTY)
annotation class JsonName(val name: String)