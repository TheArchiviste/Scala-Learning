// RANGES:
val lst7 = (1 to 10).toList

// Give up until 9 (stop at one before 10)
val lst8 = (1 until 10).toList

val lst9 = (1 to 10).toList.toString()


// EQUALITY
val a = "Dave"
val b = "Dave"

val isEqual = if (a == b) println("They are!!") else println("Nope!!")

val s = Set(1,2,3) == Set(3,2,1)
val l = List(1,2,3) == List(3,2,1)

// Cannot compare function/Arrays/..


// CONVERSION:
val set = List(1,2,3).toSet

val list = "hello".toList


// TYPES:

// We can write the types explicitly, however Scala handles that 
// well even if we do not
val name: String = "Ivan"

val errorIf = math.sqrt("64".toDouble)


// TUPES:
val p = (1, "one")

val p1 = p._1
val p2 = p._2

val t = (4,1,2,3)
val t1 = t._4