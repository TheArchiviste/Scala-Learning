// Basics
def cube(n: Int) : Int = n * n * n

val n = 3

def printCube = println(s"The cube of $n is ${cube(n)}")
// or
def printCube1 = println(s"The cube of $n is ${n * n * n}")

// Very useful for debugging
def gcd_db(a: Int, b: Int) : Int = {
    println(s"Function called with $a and $b.")
    if (b == 0) a else gcd_db(b, a % b)
}

// Creating our own
import scala.language.implicitConversions
import scala.language.reflectiveCalls

implicit def string_inters(sc: StringContext) = new {
    def i(args: Any*) : String = s"\t${sc.s(args:_*)}\n"
    def l(args: Any*) : String = s"${sc.s(args:_*)}:\n"
}

val str = i"add ${3+2}"
val str1 = l"New name"