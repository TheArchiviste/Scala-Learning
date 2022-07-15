// Sudoku

// Simple game
val game0 = """.14.6.3..
              |62...4..9
              |.8..5.6..
              |.6.2....3
              |.7..1..5.
              |..6.2..3.
              |1..5...92
              |..7.9.41.""".stripMargin.replaceAll("\\n", "")

// Game with multiple solutions
val game1 = """.8...8743
              |.5...8.1.
              |.1.......
              |8....5...
              |...8.4...
              |.......7.
              |.3.5...8.
              |9724...5.""".stripMargin.replaceAll("\\n", "")

// Harder game.
val game2 = """8........
              |..36.....
              |.7..9.2..
              |.5...7...
              |....457..
              |...1...3.
              |..1....68
              |..85...1.
              |.9....4..""".stripMargin.replaceAll("\\n", "")     

type Pos = (Int, Int)
val EmptyValue = "."
val MaxValue = 9

def pretty(game: String) : String = 
    "\n" + (game.grouped(MaxValue).mkString("\n"))

val allValues = "123456789".toList
val indexes = (0 to 8).toList

def empty(game: String) = game.indexOf(EmptyValue)
def isDone(game: String) = empty(game) == -1
def emptyPosition(game: String) = {
    val e = empty(game)
    (e % MaxValue, e / MaxValue)
}

def get_row(game: String, y: Int) = indexes.map(col => game(y * MaxValue + col))
def get_col(game: String, x: Int) = indexes.map(row => game(x + row * MaxValue))

def get_box(game: String, pos: Pos) : List[Char] = {
    def base(p: Int) : Int = (p / 3) * 3
    val x0 = base(pos._1)
    val y0 = base(pos._2)
    val ys = (y0 until y0 + 3).toList
    (x0 until x0 + 3).toList
        .flatMap(x => ys.map(y => game(x + y * MaxValue)))
}

def update(game: String, pos: Int, value: Char) : String = 
    game.updated(pos, value)

def toAvoid(game: String, pos: Pos) : List[Char] =
    (get_col(game, pos._1) ++
     get_row(game, pos._2) ++
     get_box(game, pos))


def candidates(game: String, pos: Pos) : List[Char] = 
    allValues.diff(toAvoid(game, pos))

// Can be run on parallel for all candidates
def search(game: String) : List[String] = {
    if (isDone(game)) List(game)
    else {
        val cs = candidates(game, emptyPosition(game))
        cs.flatMap(c => search(update(game, empty(game), c)))
    }
}

// This one cannot be run on parallel 
def searchT(games: List[String], sols: List[String]) : List[String] = 
    games match {
        case Nil => sols
        case game::rest => {
            if (isDone(game)) searchT(rest, game::sols)
            else {
                val cs = candidates(game, emptyPosition(game))
                searchT(cs.map(c => update(game, empty(game), c)) ::: rest, sols)
            }
        }
    }

// Stops when it finds the first solution. 
def searchT1(games: List[String]) : Option[String] = 
    games match {
        case Nil => sols
        case game::rest => {
            if (isDone(game)) Some(game)
            else {
                val cs = candidates(game, emptyPosition(game))
                searchT(cs.map(c => update(game, empty(game), c)) ::: rest, sols)
            }
        }
    }

// For measuring time:
def time_needed[T](i: Int, code: => T) = {
    val start = System.nanoTime()
    for (j <- 1 to i) code
    val end = System.nanoTime()
    s"${(end - start) / 1.0e9} secs"
}