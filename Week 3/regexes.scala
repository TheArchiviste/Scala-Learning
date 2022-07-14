val str = "foo\\n"

// Take the string as it is
// Ignore any special symbols inside it.
val str1 = """foo\\n"""

// Create a regular expression:
val reg = "a|c".r

// Need the """""" to avoid the special symbol \
val regNums = """\d""".r

val regNums1 = """\d+""".r

def findTheAsAndCs = reg.findAllIn("bbbbabbcbbbbbba").toList

def replaceTheAsAndCs = reg.replaceAllIn("bbbbabbcbbbbbba", "*")

def replaceTheNums = regNums.replaceAllIn("bb1bbabb4cb3bbbbb1a", "_")

// Will make sure to replace both with just one _
def replaceTheNums1 = regNums1.replaceAllIn("bb11bbabb44cb33bbbbb11a", "_")