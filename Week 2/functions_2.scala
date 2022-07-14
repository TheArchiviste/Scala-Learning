// Good practise is to not over complicate the functions

def my_equal(x: Int, y: Int) : Boolean = {
    // No need to introduce if statement here
    x == y
}

def my_not_equal(x: Int, y: Int) : Boolean = {
    !(x == y)
}

def sum_even(ls: List[Int]) : Int = {
    val aux = for (x <- ls) yield {
        if (x % 2 == 0) x else 0
    }
    aux.sum
}

def sum_sqr(ls: List[Int]) : Int = {
    (for (n <- ls) yield (n * n)).sum
}