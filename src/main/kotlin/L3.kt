class StringUtils {
    companion object { //think of companion object as a place to define static members
        fun doSomeStuffWithAString(item: String): String {
            return "string interpolation on $item in StringUtils companion object (essentially a location for static members and functions)"
        }
    }

    fun myFunction(): String {
        return "myfunction"
    }

    fun callMyFunction(): String {
        return myFunction()
    }
}

//Better to define a singleton
object StringUtilsObject {
    fun doSomeStuffWithAString(item: String): String {
        return "string interpolation on ${item.toLowerCase()} in a singleton"
    }
}

//Even better to define an extension function
fun String.doSomeStuffWithAString(): String {
    return "string interpolation on ${this.toLowerCase()} in an extension function on string"
}

//toLowerCase() can be called without the "this" keyword
fun String.doSomeStuffWithAStringNoThis(): String {
    val item = toLowerCase() //all public functions can be called as if they are being called inside the class. meaning no reference to "this"
    return "string interpolation on $item in an extension function on string"
}

fun main() {
    val aString = "aString"

    val string1 = StringUtils.doSomeStuffWithAString(aString)
    println(string1)

    val string2 = StringUtilsObject.doSomeStuffWithAString(aString)
    println(string2)

    val string3 = aString.doSomeStuffWithAString()
    println(string3)

//    val string4 = doSomeStuffWithAString(aString)
//    println(string4)
}

//fun doSomeStuffWithAString(item: String): String {
//    return "string interpolation on $item in an equivalent to extension function"
//}
