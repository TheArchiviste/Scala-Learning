// Adding functionality to already existing library
implicit class MyString(s: String) {
    def increment = s.map(c => (c + 1).toChar)
}

val incStr = "HAL".increment


// Timing:
import scala.concurrent.duration.{TimeUnit,SECONDS,MINUTES}
import java.time.chrono.MinguoEra

case class  Duration(time: Long, unit: TimeUnit) {
    def +(o: Duration) =
        Duration(time + unit.convert(o.time, o.unit), unit)
}

implicit class Int2Duration(that: Int) {
    def seconds = new Duration(that, SECONDS)
    def minutes = new Duration(that, MINUTES)
}

val test = 5.seconds + 2.minutes
val test1 = 2.minutes + 60.seconds


// Regular Expressions:
import scala.language.implicitConversions
import scala.language.reflectiveCalls

abstract class Rexp
case object ZERO extends Rexp
case object ONE extends Rexp
case class CHAR(c: Char) extends Rexp
case class ALT(r1: Rexp, r2: Rexp) extends Rexp
case class SEQ(r1: Rexp, r2: Rexp) extends Rexp
case class STAR(r: Rexp) extends Rexp

def charlist2rexp(s: List[Char]) : Rexp = s match {
    case Nil => ONE
    case c::Nil => CHAR(c)
    case c::s => SEQ(CHAR(c), charlist2rexp(s))
}

implicit def string2rexp(s: String) : Rexp = 
    charlist2rexp(s.toList)

implicit def rExpOps(r: Rexp) = new {
    def | (s: Rexp) = ALT(r, s)
    def % = STAR(r)
    def ~ (s: Rexp) = SEQ(r, s)
}

implicit def stringOps (s: String) = new {
    def | (r: Rexp) = ALT(s, r)
    def | (r: String) = ALT(s, r)
    def % = STAR(s)
    def ~ (r: Rexp) = SEQ(s, r)
    def ~ (r: String) = SEQ(s, r)
}

val digit = ("0" | "1" | "2"| "3" | "4" | "5" | "6" | "7" | "8" | "9")
val sign = ("+" | "-" | "")
val number = sign ~ digit ~ digit.%

val test3 = STAR("Hello")


// Complex Numbers:

