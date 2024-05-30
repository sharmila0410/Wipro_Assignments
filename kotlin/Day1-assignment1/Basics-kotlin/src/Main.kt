fun main() {
    println("Kotlin syntax and basic operations");

    println("------------------------")
    println("variables and data types")
    val name = "sharmila"
    var age = 25
    val ht: Double = 5.7
    var isTraining: Boolean = true

    println("------------------------")
    println("control flow using kotlin")
    val x = 10
    val y = 20
    if(x>y){
        println("x is greater than y")
    }else{
        println("y is greater than x")
    }
    println("------------------------")
    println("string manipulation")
    val firstName = "Sym"
    val lastName = "Dara"
    val fullName = "$firstName $lastName"
    println("hello, $fullName")

    println("------------------------")
    println("functionexample using kotlin")
    fun add(x: Int, y: Int): Int{
        return x + y
    }
    println(add(4,10))

    println("------------------------")
    println("classes and objects")
    class Person(val name: String, var age: Int)

    val person = Person("sym", 23)
    println("${person.name} is ${person.age} years old.")


}