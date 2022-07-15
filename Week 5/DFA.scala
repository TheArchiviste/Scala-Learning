// Deterministic Finite Automata

// Good example of the OO paradigm !!

import scala.util.Try

case class DFA[A, C](start: A,                  // Starting state
                     delta: (A, C) => A,        // Transition function
                     fins: A => Boolean) {      // Final state (Set)
                     
    def deltas(q: A, s: List[C]) : A = s match {
        case Nil => q
        case c::cs => deltas(delta(q, c), cs)
    }

    def accepts(s: List[C]) : Boolean =
        Try(fins(deltas(start, s))).getOrElse(false)
}

abstract class State
case object Q0 extends State
case object Q1 extends State
case object Q2 extends State
case object Q3 extends State
case object Q4 extends State

val delta: (State, Char) => State = {
    case (Q0, 'a') => Q1
    case (Q0, 'b') => Q2
    case (Q1, 'a') => Q4
    case (Q1, 'b') => Q2
    case (Q2, 'a') => Q3
    case (Q2, 'b') => Q2
    case (Q3, 'a') => Q4
    case (Q3, 'b') => Q0
    case (Q4, 'a') => Q4
    case (Q4, 'b') => Q4
    case _ => throw new Exception("Undefined")
}

val dfa = DFA(Q0, delta, Set[State](Q4))