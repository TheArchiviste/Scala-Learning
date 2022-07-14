// Jumping Towers

def moves(xs: List[Int], n: Int) : List[List[Int]] = 
(xs, n) match {
    case (Nil, _) => Nil
    case (_, 0) => Nil
    case (x::xs, n) => (x::xs) :: moves(xs, n-1)
}

// If there exists a way to the end.
def search(xs: List[Int]) : Boolean = xs match {
    case Nil => true
    case x::xs =>
        if (xs.length < x) true
        else moves(xs, x).exists(search(_))
}

// Calculating the shortest distance to the end.
// Not efficient !!!
def jumps(xs: List[Int]) : List[List[Int]] =
xs match {
    case Nil => Nil
    case x::xs => {
        val children = moves(xs, x)
        val results = 
            children.map(cs => jumps(cs).map(x :: _)).flatten
        if (xs.length < x) List(x) :: results else results
    }
}

import scala.util._

val lst = List.fill(100)(Random.nextInt(10))

val lst1 = List.fill(10)(Random.nextInt(10))

def searchJT = search(lst)

def jumpJT = jumps(lst1)

def min_jump = jumps(lst1).minBy(_.length)