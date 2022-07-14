// Essentially a loop. However it does not mutate anything.

// To check whether a function is tail-recursive
import scala.annotation.tailrec

@tailrec
def factT(n: BigInt, acc: BigInt) : BigInt = 
    if (n == 0) acc else factT(n - 1, n * acc)

val valFactT = factT(10, 1)
// Will not break on this, unlike normal recursion
val valFactT = factT(10000, 1)


@tailrec
def lengthT(xs: List[Int], acc: Int) : Int = xs match {
    case Nil => acc
    case _ :: tail => lengthT(tail, 1 + acc)
}

val valFactT = lengthT(List.fill(10000)(1), 0)
