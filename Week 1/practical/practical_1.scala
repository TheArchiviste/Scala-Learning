// Practical 1
//==========================================

//============ QUESTION 1
// Basics
val a = 2 + 2

val b = 1 / 2           // Floor division - integers
val b1 = 3 / 2      

val c = 1.0 / 2         // Precise divison - floating points
val c1 = 1 / 2.0

val d = 1 / 0

val e = true == false

val f = true && false

val g = 1 > 1.0

// Strings
val h = "123456".length

// Lists
val i = List(1, 2, 1).size              // Lists -> repetions count, ordered

val j = List(1) == List(1)

// Sets
val k = Set(1, 2, 1).size               // Sets -> repetions dismissed, not ordered

val l = Set(1, 2, 3) == Set(3, 2, 1)

// Arrays
val m = Array(1) == Array(1)

val n = Array(1).sameElements(Array(1))
// ======== ======== ======== //

//============ QUESTION 2
val z = 42

def addToZ(z: Int) : Int = z + 1

val x = 2 * z

val z = 466
// ======== ======== ======== //

//============ QUESTION 3
val print = println("Hello" ++ " " ++ "World")

val list = List(1, 2, 3, 4).mkString("\n")

val list1 = List(1, 2, 3, 4).mkString("(", "|", ")")
// ======== ======== ======== //

//============ QUESTION 4
def miles2meters(m: Int) : Int = m * 1609
// ======== ======== ======== //

//============ QUESTION 5 - IF-THEN-ELSE
// They are expressions, meaning they need to calculate a result. 
// For example an if without an else‑branch is nearly always not what 
// you intend to write (because you are not meant to change any “state” 
// outside the expression)

val s1 = "foo"
val s2 = "bar"
val s3 = "foobar"

def check = if (s1 == s2) println("equal") else println("not equal")
def check = if (s1 ++ s2 == s3) println("equal") else println("not equal")
// ======== ======== ======== //

//============ QUESTION 6 - FOR-COMPREHENSION
val list = for (x <- (1 to 5).toList; 
                y <- (1 to 5).toList;
                z <- (1 to 5).toList) yield (x, y, z)

def divisibleBy3(ls: List[(Int, Int, Int)]) : List[(Int, Int, Int)] = {
    for (tup <- ls if (tup._1 + tup._2 + tup._3) % 3 == 0) yield tup
}

val lst1 = for (x <- (1 to 5).toList; 
                y <- (1 to 5).toList;
                z <- (1 to 5).toList;
                if (x + y + z) % 3 == 0) yield (x, y, z)


def sortedDivisibleBy3(ls: List[(Int, Int, Int)]) : List[(Int, Int, Int)] = {
    (for (tup <- ls if (tup._1 + tup._2 + tup._3) % 3 == 0) yield tup).sortBy(_._2)
}

val lst2 = (for (x <- (1 to 5).toList; 
                y <- (1 to 5).toList;
                z <- (1 to 5).toList;
                if (x + y + z) % 3 == 0) yield (x, y, z)).sortBy(_._2)
// ======== ======== ======== //

//============ QUESTION 7 - RECURSION
// Convert to String
def toStr(tup: (Int, Int)) = 
    if (tup._2 == 1) s"${tup._1}" else s"${tup._2} x ${tup._1}"

// V1 -> Using an accumulator.
def condense(lst: List[Int], acc: List[(Int, Int)] = Nil) : List[(Int, Int)] = (ls, acc) match {
    case (Nil, acc) => acc.reverse
    case (x :: xs, Nil) => condense(xs, (x, 1) :: Nil)
    case (x :: xs, (y, n) :: ys) =>
        if (x == y) condense(xs, (y, n + 1) :: ys)
            else condense(xs, (x, 1) :: (y, n) :: ys)
}

def organise(lst: List[Int]) = {
    condense(lst).map(toStr)
}

// pp_list(List(1,1,1,2,3,3))    //   List(3 x 1, 2, 2 x 3)
// pp_list(List(1,2,3,4,4,4))    //   List(1, 2, 3, 3 x 4)
// pp_list(List(1,1,1,1,1,1))    //   List(6 x 1)
// pp_list(List(1,1,1,2,1,1))    //   List(3 x 1, 2, 2 x 1)

// V2 -> Using a counter.
def condense2(lst: List[Int], n: Int = 0) : List[(Int, Int)] = lst match {
    case Nil => Nil
    case x :: Nil => (x, n + 1) :: Nil
    case x :: y :: tail => 
        if (x == y) condense2(y :: tail, n + 1)
            else (x, n + 1) :: condense2(y :: tail, 0)
} 

def organise2(lst: List[Int]) = {
    condense2(lst).map(toStr)
}   

// pp_list2(List(1,1,1,2,3,3))    //   List(3 x 1, 2, 2 x 3)
// pp_list2(List(1,2,3,4,4,4))    //   List(1, 2, 3, 3 x 4)
// pp_list2(List(1,1,1,1,1,1))    //   List(6 x 1)
// pp_list2(List(1,1,1,2,1,1))    //   List(3 x 1, 2, 2 x 1)
// ======== ======== ======== //

// ======== ======== ======== ======== //

