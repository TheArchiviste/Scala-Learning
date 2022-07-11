// Functions as variables:
def even(x: Int) : Boolean = x % 2 == 0
def odd(x: Int) : Boolean = x % 2 == 1

val lst = (1 to 10).toList

def evenList = lst.filter(even)
def coutOdd = lst.count(odd)
def findEven = lst.find(even)
def existsEven = lst.exists(even)


def lowerList = lst.filter(_ < 4)
// or
def less4(x: Int) : Boolean = x < 4
def lowerList1 = lst.filter(less4)

def lowerNum = lst.find(_ < 4)
// or
def lowerNum1 = lst.find(less4)

// Anonymous Functions:
def lowerListA = lst.filter(x => x < 4)
def lowerNumA = lst.find(x => x < 4)

def evenListA = lst.filter(x => x % 2 == 0)
def evenListA1 = lst.filter(_ % 2 == 0)

def sortA = lst.sortWith((x,y) => x > y)
// difficult to read !!!
// Only works when the arguements are 'clear'
def sortA1 = lst.sortWith(_ > _)

// Wont work here
// n is used twice
def greterOdd = lst.find(n => odd(n) && n > 2)


val ps = List((3,0), (3,2), (4,2), (2,2), (2,0), (1,1), (1,0))

def lex(x: (Int, Int), y: (Int, Int)) : Boolean = 
    if (x._1 == y._1) x._2 < y._2 else x._1 < y._1

def sortLex = ps.sortWith(lex)

// Sort them lex. by the first element
def sortLex1 = ps.sortBy(x => x._1)
// by the second element
def sortLex2 = ps.sortBy(_._2)

def max1 = ps.maxBy(_._1)
def max2 = ps.maxBy(_._2)


// Defining a higher-order function
// Also recursive
def my_map_int(lst: List[Int], f: Int => Int) : List[Int] = {
    if (lst == Nil) Nil
    else f(lst.head) :: my_map_int(lst.tail, f)
}

// Using Pattern Matching
def my_map_int1(lst: List[Int], f: Int => Int) : List[Int] = 
lst match {
    case Nil => Nil
    case x::xs => f(x)::my_map_int1(xs,f)
}