def loop : List[Int] = for (n <- List(1,2,3,4,5)) yield n * n

// Declarations:
val lst = (1 to 10).toList
val lst1 = (1 to 5).toList
val lst2 = (1 to 3).toList
val lst3 = List((1,4), (2,3), (3,2), (4,1))
val lst4 = ('a' to 'm').toList

// The outcome can be stored in a value
val mult_table = 
    for (n <- lst; m <- lst1) yield (n, m, m*n)

// Helper functions:
def double(n:Int) : Int = 2 * n

def square(n:Int) : Int = n * n

// Practise:
def loop1 = for (n <- lst) yield n * n

def loop2 = for (n <- lst) yield {
    square(n) + double(n)
}

def loop3 = for (n <- lst; m <- lst1) yield (n,m)

def loop4 = for (n <- lst; m <- lst1) yield (n, m, m*n)

def printIt = println(mult_table.mkString)

def slide = mult_table.sliding(10,10).mkString("\n")

// The for-comprehensions produce from a type the same type
// after execution e.g. -> range => new range, list => new list

def filter = for (n <- lst2; m <- lst2; 
                    // Filter!!!
                    if (n + m) % 2 == 0) yield (n,m)

// Pattern maching
def pattern = for ((m,n) <- lst3) yield m + n

def pattern1 = for (p <- lst3) yield p._1 + p._2

// Printing!!!
// Only exception in regards to the no changes rule!!!
def printIt1 = for ( n <- (1 to 10).toList) println(n * n)

def printChars = for(c <- lst4) println(c)