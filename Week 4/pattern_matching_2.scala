// We can only use each delcared variable for one specific 
// task throughout the pattern match!!!

// The most specific case at the top
// The most general at the bottom

def foo(xs: List[Int]) : String = xs match {
    case Nil => s"This is empty!"
    // Using guards
    case x :: y :: rest if x == y => s"This has two elements that are the same!"
    case hd :: tl => s"This list is standard $hd::$tl!"
}