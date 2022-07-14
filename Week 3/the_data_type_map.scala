val m = Map(1 -> "one", 2 -> "two")

val m1 = List((1,"one"), (2,"two")).toMap

// Creates a new map, does not mutate the old one!!!
val new_M = m + (5 -> "five")

val m2 = for((k,v) <- m) yield (k, v.toUpperCase)


def getValueFromKey = m.get(1)

def getValueFromKey1 = m.getOrElse(1, "")
def getValueFromKey2 = m.getOrElse(3, "")


// Also creates maps:
val lst = List("one", "two", "three")

val lst1 = lst.groupBy(_.head)

val lst2 = lst.groupBy(_.length)

val lst3 = lst.groupBy(_.length).get(3)

def allKeys = lst2.keySet

