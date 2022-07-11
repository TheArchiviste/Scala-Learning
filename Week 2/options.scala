def opList = List(7,2,3,4,5,6).find(_ < 4)

def opList1 = List(5,6,7,8,9).find(_ < 4)

// The case - x / 0
def div(x: Int, y: Int) : Int = x / y

def safe_div(x: Int, y: Int) : Option[Int] = 
    if (y == 0) None else Some(x / y)

// The case - empty list
def my_min(ls: List[Int]) : Int = ls.min

def safe_my_min(ls: List[Int]) : Option[Int] = ls.minOption


// Working with options
val lst = List(None, Some(1), Some(2), None, Some(3))

def removeNone = lst.flatten

// Some(1).isDefined
// Some(1).get
// !!! Doest work on None !!!

def flattenLst = for (x <- lst) yield x.getOrElse(0)


// Handling URLs
import scala.util._
import  io.Source

val my_url = "https://github.com/TheArchiviste/Scala-Learning"

| Source.fromURL(my_url)("ISO-8859-1").mkString

| Try(Source.fromURL(my_url)("ISO-8859-1").mkString).getOrElse("")

| Try(Some(Source.fromURL(my_url)("ISO-8859-1").mkString)).getOrElse(None)

// The same applies for files

| Try(Some(Source.fromFile("test.txt")("ISO-8859-1").mkString)).getOrElse(None)