def double1(x: Int) : Int = 2 * x
def square(x: Int) : Int = x * x

val lst = (1 to 10).toList

def mapSqr = lst.map(square)
def mapSqrDoub = lst.map(x => (square(x), double(x)))

// Works for strings
def tweet(c: Char) = c.toUpper

def strUp = "Hello World".map(tweet)


// Iterating over the mapped functions:
def myFun = lst.map(square).filter(_ > 4)

def myFun1 = lst.map(square).find(_ > 4)

// If we want to apply a function to the content
// of Some() ...
def myFun2 = lst.map(square).find(_ > 4).map(double1)


// Maps on Options:
import scala.util._

def get_me_an_int(s: String) : Option[Int] = 
    Try(Some(Integer.parseInt(s))).getOrElse(None)

def check1 = get_me_an_int("12345").map(_ % 2 == 0)
def check2 = get_me_an_int("12u45").map(_ % 2 == 0)

val lst = List("12345", "foo", "5432", "bar", "x21")

def onlyInts = for (x <- lst) yield get_me_an_int("12345")

def sumThemUp = lst.map(get_me_an_int).flatten.sum

