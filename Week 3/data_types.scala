import javax.net.ssl.TrustManager
abstract class Tree

case class Leaf(x: Int) extends Tree
case class Node(s: String, left: Tree, right: Tree) extends Tree

// If it is defined with just class => we will need new when assigning
// the value to val

val lf = Leaf(20)
val tr = Node("foo", Leaf(10), Leaf(23))

val lst : List[Tree] = List(lf, tr)



abstract class Colour

// When there will be just one instance of this obj
case object Red extends Colour
case object Blue extends Colour
case object Green extends Colour

def fav_colour(c: Colour) : Boolean = c match {
    case Green => true
    case _ =>  false
}



// Sealed -> cannot introduce any more new objs.
sealed abstract class RomanDigit
case object I extends RomanDigit
case object V extends RomanDigit
case object X extends RomanDigit
case object L extends RomanDigit
case object C extends RomanDigit
case object D extends RomanDigit
case object M extends RomanDigit

type RomanNumeral = List[RomanDigit]

def roman_Numeral_To_Int(rs: RomanNumeral) : Int = rs match {
    case Nil => 0
    case M::r => 1000 + roman_Numeral_To_Int(r)
    case C::M::r => 900 + roman_Numeral_To_Int(r)
    case D::r => 500 + roman_Numeral_To_Int(r)
    case C::D::r => 400 + roman_Numeral_To_Int(r)
    case C::r => 100 + roman_Numeral_To_Int(r)
    case X::C::r => 90 + roman_Numeral_To_Int(r)
    case L::r => 50 + roman_Numeral_To_Int(r)
    case X::L::r => 40 + roman_Numeral_To_Int(r)
    case X::r => 10 + roman_Numeral_To_Int(r)
    case I::X::r => 9 + roman_Numeral_To_Int(r)
    case V::r => 5 + roman_Numeral_To_Int(r)
    case I::V::r => 4 + roman_Numeral_To_Int(r)
    case I::r => 1 + roman_Numeral_To_Int(r)
}


// Expressions:
abstract class Exp

case class N(n: Int) extends Exp
case class Plus(e1: Exp, e2: Exp) extends Exp
case class Times(e1: Exp, e2: Exp) extends Exp

def string(e: Exp) : String = e match {
    case N(n) => s"$n"
    case Plus(e1,e2) => s"${string(e1) + string(e2)}"
    case Plus(e1,e2) => s"${string(e1) * string(e2)}"
}

val e = Plus(N(9), Times(N(3), N(4)))

val e_String = e.toString

def printIt = println(string(e))

def eval(e: Exp) : Int = e match {
    case N(n) => n
    case Plus(e1, e2) => eval(e1) + eval(e2)
    case Times(e1, e2) => eval(e1) * eval(e2)
}

def printFinal = println(eval(e))

// Simplification rules
def simp(e: Exp) : Exp = e match {
    case N(n) => N(n)
    case Plus(e1, e2) => (simp(e1), simp(e2)) match {
        case (N(0), e2s) => e2s
        case (e1s, N(0)) => e1s
        case (e1s, e2s) => Plus(e1s, e2s)
    }
    case Times(e1, e2) => (simp(e1), simp(e2)) match {
        case (N(0), _) => N(0)
        case (_, N(0)) => N(0)
        case (N(1), e2s) => e2s
        case (e1s, N(1)) => e1s
        case (e1s, e2s) => Times(e1s, e2s)
    }
}

val e2 = Times(Plus(N(0), N(1)), Plus(N(0), N(9)))

def printIt2 = println(string(e2))

def printFinal2 = println(simp(e2))