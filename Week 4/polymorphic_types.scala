def lengthP[A](lst: List[A]) : Int = lst match {
    case Nil => 0
    case x :: xs => 1 + lengthP(xs)
}

def mapP[A, B](lst: List[A], f: A => B) : List[B] = lst match {
    case Nil => Nil
    case x :: xs => f(x)::mapP(xs, f)
}

// Identity function
val x = id(322)         // Int
val y = id("Hey")       // String
val z = id(Set(1,2,3))  // Set[Int]