// A function that take an arbitrary number of 
// variables
def printAll(strings: String*) = {
    strings.foreach(println)
}

val fruits = List("Apple", "Banana", "Cherry")

val printFruits = printAll(fruits: _*)


// Implement our own string interpolations.