// Evaluates from top to bottom !!!
// Always put the default case at the end !!!
def season(month: String) : String = month match {
    case "March" | "April" | "May" => "Spring"
    case "June" | "July" | "August" => "Summer"
    case "September" | "October" | "November" => "Autumn"
    case "December" | "January" | "February" => "Winter"
    case _ => "Wrong month!"
}

def fib(n: Int) : Int = {
    case 0 | 1 => 1
    case n => fib(n-1) + fib(n-2)
}

def fizz_buzz(n: Int) : String = (n % 3, n % 5) match {
    case (0,0) => "Fizz Buzz"
    case (0,_) => "Fizz"
    case (_,0) => "Buzz"
    case _ => n.toString
}

def tryFB = {
    for (n <- 1 to 20)
    println(fizz_buzz(n))
}

val lst = List(None, Some(1), Some(2), None, Some(3))

def my_flatten(xs: List[Option[Int]]) : List[Int] = 
xs match {
    case Nil => Nil
    case None::rest => my_flatten(rest)
    case Some(v)::rest => v :: my_flatten(rest)
}