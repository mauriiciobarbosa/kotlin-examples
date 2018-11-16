fun main() {
    val dependencies = DependencyHandler()

    dependencies.compile("org.jetbrains.kotlin:kotlin-stdlib:1.3.10")

    dependencies {
        println("like DSL")

        compile("org.jetbrains.kotlin:kotlin-stdlib:1.3.10")
        compile("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.10")
        compile("com.android.tools.build:gradle:3.2.1")
    }
}

class DependencyHandler {
    fun compile(coordinate: String) {
        println("added dependency on $coordinate")
    }

    operator fun invoke(body: DependencyHandler.() -> Unit) {
        body()
    }
}