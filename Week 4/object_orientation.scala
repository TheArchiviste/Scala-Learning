abstract class Animal
case class Bird(name: String) extends Animal {
    override def toString(): String = name
}
case class Mammal(name: String) extends Animal
case class Reptile(name: String) extends Animal

// The difference
val bird0 = Bird("Sparrow")
val bird1 = Bird("Sparrow").copy(name = "House Sparrow")
val mammal = Mammal("Zebra")


def group(a: Animal) = a match {
    case Bird(_) => "It's a bird!"
    case Mammal(_) => "It's a mammal!"
}


class Fraction(x: Int, y: Int) {
    def numer = x
    def denom = y
}
val half = new Fraction(1, 2)

case class Fraction(numer: Int, denom: Int)
val half = Fraction(1, 2)


// Imaginary numbers and their arithmetic operations.
case class Complex(re: Double, im: Double) {
    // Represents the complex number re + im * i
    def +(that: Complex) = Complex(this.re + that.re, this.im + that.im)
    def -(that: Complex) = Complex(this.re - that.re, this.im - that.im)
    def *(that: Complex) = Complex(this.re * that.re - this.im *that.im,
                                   this.re * that.im + this.im *that.re)
    def *(that: Double) = Complex(this.re * that, this.im * that)
    def abs = Math.sqrt(this.re * this.re + this.im * this.im)
}

// The (.) is optional if we use operators as names of a function
// Or include the library import scala.language.postfixOps to be the case for everything
val test0 = Complex(1, 2) + Complex(3, 4)
val test1 = Complex(1, 2).+(Complex(3, 4))


case class BankAccount(init: Int) {
    private  var balance = init

    def deposit(amount: Int): Unit = {
        if (amount > 0) balance = balance + amount
    }

    def withdraw(amount: Int): Int = 
        if (0 < amount && amount <= balance) {
            balance = balance - amount
            balance
        } else throw new Error("Insufficient funds!!")
}