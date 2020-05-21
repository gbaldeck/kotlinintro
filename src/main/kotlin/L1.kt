class L1{
    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    var prop1: String = "hello" //creates getters and setters automatically

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    val finalProp: String = "final" //immutable. Only creates getter, cannot set.

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    val prop2: String //custom getter
        get() = "thisString"

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////


    private var _traditionalBackingField: String = ""

    var traditionalBackingFieldProp: String //custom getter and setter using traditional
        get() {
            if(_traditionalBackingField == "avalue") {
                return "a"
            }
            else {
                return "b"
            }
        }
        set(value) {
            if (value == "avalue") {
                _traditionalBackingField = value
            }
        }

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    var backingFieldProp: String = "" //custom getter and setter using backing field via the "field" keyword
        get() {
            if(field == "avalue")
                return "a"
            else
                return "b"
        }
        set(value) {
            if (value == "avalue") {
                field = value
            }
        }

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    fun toLowerCaseBlock(itemA: String): String {
        return itemA.toLowerCase()
    }

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    fun toLowerCaseExpression(itemA: String) = itemA.toLowerCase()

}

fun main() {
    val l1 = L1() //initializes L1 class, the "new" keyword is omitted

    l1.prop1 = "item" //calls prop1 setter
    val s1 = l1.prop1 //calls prop1 getter
    println(s1) //prints item

    l1.finalProp = "can't set"

    println(l1.prop2) //calls prop2 getter and prints "thisString"

    l1.traditionalBackingFieldProp = "prop"
    println(l1.traditionalBackingFieldProp) // prints b

    l1.backingFieldProp = "avalue"
    println(l1.backingFieldProp)// prints a
}