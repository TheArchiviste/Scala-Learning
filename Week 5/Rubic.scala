// 2x2 Rubic Cube
import java.{util => ju}

abstract class Colour
case object White extends Colour
case object Red extends Colour
case object Yellow extends Colour
case object Orange extends Colour
case object Green extends Colour
case object Blue extends Colour

// 4x4 Cube
case class Face(c11: Colour, c12: Colour,
                c21: Colour, c22: Colour)

case class Cube(f1: Face, f2: Face, f3: Face,
                f4: Face, f5: Face, f6: Face)

val init = Cube(Face(White, Green, White, White),
                Face(Blue, Yellow, Orange, Red),
                Face(Red, Blue, Red, Blue),
                Face(White, Yellow, Red, Orange),
                Face(Yellow, Green, Blue, Green),
                Face(Yellow, Green, Orange, Orange))

val solved = Cube(Face(Yellow, Yellow, Yellow, Yellow),
                  Face(Orange, Orange, Orange, Orange),
                  Face(Red, Red, Red, Red),
                  Face(White, White, White, White),
                  Face(Blue, Blue, Blue, Blue),
                  Face(Green, Green, Green, Green))


// The possible moves (actions) of the cube
def up(c: Cube) : Cube = Cube(Face(c.f1.c11, c.f3.c12, c.f1.c21, c.f3.c22),
                              Face(c.f2.c11, c.f1.c12, c.f2.c21, c.f1.c22),
                              Face(c.f3.c11, c.f4.c12, c.f3.c21, c.f4.c22),
                              Face(c.f4.c11, c.f2.c12, c.f4.c21, c.f2.c22),
                              Face(c.f5.c11, c.f5.c12, c.f5.c21, c.f5.c22),
                              Face(c.f6.c21, c.f6.c11, c.f6.c22, c.f6.c12))

def clock(c: Cube) : Cube = Cube(Face(c.f1.c21, c.f1.c11, c.f1.c22, c.f1.c12),
                                 Face(c.f2.c11, c.f2.c12, c.f5.c22, c.f5.c12),
                                 Face(c.f6.c21, c.f6.c11, c.f3.c21, c.f3.c22),
                                 Face(c.f4.c11, c.f1.c12, c.f4.c21, c.f4.c22),
                                 Face(c.f5.c11, c.f3.c11, c.f5.c21, c.f3.c12),
                                 Face(c.f2.c21, c.f6.c12, c.f1.c22, c.f6.c22))

def right(c: Cube) : Cube = Cube(Face(c.f5.c11, c.f5.c12, c.f1.c21, c.f1.c12),
                                 Face(c.f2.c12, c.f2.c22, c.f2.c11, c.f2.c21),
                                 Face(c.f3.c11, c.f3.c12, c.f3.c21, c.f3.c22),
                                 Face(c.f4.c11, c.f4.c12, c.f6.c12, c.f6.c11),
                                 Face(c.f4.c22, c.f4.c21, c.f5.c21, c.f5.c22),
                                 Face(c.f1.c11, c.f1.c12, c.f6.c21, c.f6.c22))

// Problem with space complexity
def actions(c: Cube) : Set[Cube] = 
    Set(up(c), clock(c), right(c))

def search(cs: Set[Cube]) : Boolean = {
    if (cs.contains(solved)) true
    else search(cs.flatMap(actions))
}

// To get which actions get us to the result.
abstract class Action
case object Up extends Action
case object Clock extends Action
case object Right extends Action

type Actions = List[Action]

def actions(c: Cube, as: Actions) : Map[Cube, Actions] =
    Map(up(c) -> (Up::as),
        clock(c) -> (Clock::as),
        right(c) -> (Right::as)) 

// Bi-directional Breadth-First-Search
def bsearch(cs: Map[Cube, Actions], bs: Map[Cube, Actions]) : Actions = {
    val res = cs.keySet intersect bs.keySet
    if (!res.isEmpty) (cs(res.head).reverse ::: bs(res.head))
    else bsearch(cs.flatMap{case (c, as) => actions(c, as)},
                 bs.flatMap{case (c, as) => actions(c, as)})
}