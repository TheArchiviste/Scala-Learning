// COLLECTIONS:
val lst1 = Nil  

val lst = List(1,2,3,1)

val lst1 = Nil  // empty list

val lst2 = 1 :: 2 :: 3 :: Nil

// Works only for lists !!!
val lst3 = List(1,2,3) ::: List(4,5,6)

// Works for List, Sets, est.
val lst4 = List(1,2,3) ++ List(3,6,5)

val lst5 = List(1,2,3).head

// Returns a list of all elements but the tail
val lst6 = List(1,2,3).tail


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


// STRINGS
val str = println("Hello")

val str1 = println(lst.mkString)

val str2 = println(lst.mkString(","))

val str2 = println(lst.mkString("{", ",", "}"))

val str3 = "1,2,3,4,5".split(",").mkString("\n")

val str4 = "1,2,3,4,5".split(",").toList

val str5 = "1,2,3,4,5".split(",3,").mkString("\n")

val str5 = "abcdgfgswrg".startsWith("abc")


// CONVERSION:
val set = List(1,2,3).toSet

val list = "hello".toList


// USEFUL LIST METHODS:
val list1 = List(1,2,3,1).length

val list1 = List(1,2,3,1).reverse

val list1 = List(1,2,3,1).max

val list1 = List(1,2,3,1).min

val list1 = List(1,2,3,1).sum

// Take the first 2 and sum them
val list1 = List(1,2,3,1).take(2).sum

// Drop the first two and sum
val list1 = List(1,2,3,1).drop(2).sum

val list1 = List(1,2,3,1).indexOf(3)


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