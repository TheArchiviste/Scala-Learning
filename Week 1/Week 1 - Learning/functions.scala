def incr(x: Int) : Int = x + 1

def double(x: Int) : Int = x + x
def double1(x: Int) : Int = 2 * x

def square(x: Int) : Int = x * x

def str(x: Int) : String = {
    x.toString
}

// Factorial
def fact(n: BigInt) = {
    if (n == 0) 1 else n * fact(n - 1)
}

// Fibonacci
def fib(n: Int) : Int = {
    if (n == 0) 1 else
        if (n == 1) 1 else fib(n - 1) + fib(n - 2)
}

//
def average(xs: List[Int]) : Int = {
    val s = xs.sum
    val n = xs.length
    // Returns the whatever the last expression produces
    s / n
}

// Better practice
def average1(xs: List[Int]) : Int = {
    if (xs.length == 0) 0 
    else xs.sum / xs.length
}