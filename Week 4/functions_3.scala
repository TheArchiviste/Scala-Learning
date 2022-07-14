// A function that take an arbitrary number of 
// variables
def printAll(strings: String*) = {
    strings.foreach(println)
}

val fruits = List("Apple", "Banana", "Cherry")

val printFruits = printAll(fruits: _*)


// Implement our own string interpolations.
import scala.language.implicitConversions
import scala.language.reflectiveCalls

implicit  def string_inters(sc: StringContext) = new {
    def i(args: Any*) : String = s"${sc.s(args:_*)}\n"
}

def addInters = i"add ${3+2} ${3 * 3}"


// Default Arguements:
def lengthT(xs: List[Int], acc: Int = 0) : Int = xs match {
    case Nil => acc
    case _ :: tail => lengthT(tail, 1 + acc)
}

val valFactT = lengthT(List.fill(10000)(1))

def factT(n: BigInt, acc: BigInt = 1) : BigInt = 
    if (n == 0) acc else factT(n - 1, n * acc)

val valFactT = factT(10000)