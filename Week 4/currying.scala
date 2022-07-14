def add(x: Int, y: Int) = x + y

val lst = List(1,2,3,4,5).map(add(3,_))

// Give the arguements of the function in a delayed 
def add1(x: Int)(y: Int) = x + y

val lst1 = List(1,2,3,4,5).map(add1(3))

val a3 : Int => Int = add1(3)


def find[A](xs: List[A])(pred: A => Boolean) : Option[A] = xs match {
        case Nil => None
        case hd :: tl => 
            if (pred(hd)) Some(hd) else find(tl)(pred)
}

val flst = find(List(1,2,3))(x => x % 2 == 0)


// Also in:
// Source.fromURL(url)(encoding)
// Source.fromFile(name)(encoding)