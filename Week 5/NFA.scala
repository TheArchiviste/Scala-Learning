import scala.util.Try

case class NFA[A, C] (starts: Set[A],
                      delta: (A, C) => Set[A],
                      fins: A => Boolean) {
    
    // Given a state and a character, what is the set of
    // next states? If there is none => empty set
    def next(q: A, c: C) : Set[A] = 
        Try(delta(q, c)).getOrElse(Set[A]())

    def nexts(qs: Set[A], c: C) : Set[A] = 
        qs.flatMap(next(_, c))

    // Depth-First version of accepts
    def search(q: A, s: List[C]) : Boolean = s match {
        case Nil => fins(q)
        case c::cs => next(q, c).exists(search(_, cs))
    }

    def accepts(s: List[C]) : Boolean = 
        starts.exists(search(_, s))
}

abstract class State
case object Q0 extends State
case object Q1 extends State
case object Q2 extends State

val nfa_trans1 : (State, Char) => Set[State] = {
    case (Q0, 'a') => Set(Q0, Q1)
    case (Q0, 'b') => Set(Q2)
    case (Q1, 'a') => Set(Q1)
    case (Q1, 'b') => Set(Q2)
}

val nfa = NFA(Set[State](Q0), nfa_trans1, Set[State](Q2))


// The subset construction
def subset[A, C](nfa: NFA[A, C]) : DFA[Set[A], C] = {
    DFA(nfa.starts,
        { case (qs, c) => nfa.nexts(qs, c) },
        _.exists(nfa.fins))
}