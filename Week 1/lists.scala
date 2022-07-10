val lst = Nil  

val lst1 = List(1,2,3,1)

val lst2 = 1 :: 2 :: 3 :: Nil

// Works only for lists !!!
val lst3 = List(1,2,3) ::: List(4,5,6)

// Works for List, Sets, est.
val lst4 = List(1,2,3) ++ List(3,6,5)

val lst5 = List(1,2,3).head

// Returns a list of all elements but the tail
val lst6 = List(1,2,3).tail


// USEFUL LIST METHODS:
val list7 = List(1,2,3,1).length

val list7 = List(1,2,3,1).reverse

val list7 = List(1,2,3,1).max

val list7 = List(1,2,3,1).min

val list7 = List(1,2,3,1).sum

// Take the first 2 and sum them
val list7 = List(1,2,3,1).take(2).sum

// Drop the first two and sum
val list7 = List(1,2,3,1).drop(2).sum

val list7 = List(1,2,3,1).indexOf(3)