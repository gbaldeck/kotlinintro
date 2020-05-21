
class L2 {
    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    val immutableAndNonNullable: String = "immutableAndNonNullable"

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    val immutableAndNullable: String? = null

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    var mutableAndNonNullable: String = "mutableAndNonNullable"

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    var mutableAndNullable: String? = "mutableAndNullable"

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    var cannotBeNull = "notNull" //type inference
    var canBeNull: String? = ""
}

fun main(){
    val l2 = L2()

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    l2.immutableAndNonNullable = ""
    l2.immutableAndNonNullable = null

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    l2.immutableAndNullable = "cannot assign since it is final"
    l2.immutableAndNullable = null

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    l2.mutableAndNonNullable = "assigned"
    l2.mutableAndNonNullable = null

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    l2.mutableAndNullable = "assigned"
    l2.mutableAndNullable = null

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    //Null aware operators

    val item1 = l2.canBeNull?.toLowerCase() //the safe-call operator, type item1 is String?

    val item2 = l2.canBeNull?.toLowerCase()!! //non-null assertion operator. item2 type is String, but an NPE will be thrown if l2.canBeNull is null

    val item3 = l2.canBeNull?.toLowerCase() ?: "fallback" //elvis operator. item3 type is String, no NPE will be thrown

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    var canBeNull: String? = "canBeNull" //equivalent to l2.mutableAndNullable
    var cannotBeNull: String = "cannotBeNull" //equivalent to l2.mutableAndNonNullable

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    /* Problem: trying to assign String? to String */
    cannotBeNull = canBeNull


    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    /* Solution */
    cannotBeNull = canBeNull ?: "fallback value" //elvis operator with a fallback value

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////


    /* Solution */
    cannotBeNull = canBeNull!! //not null assertion operator, will throw an NPE if canBeNull is null


    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    /* Solution */
    if(canBeNull != null) //fine for local variables
        cannotBeNull = canBeNull //a smart cast from String? to String is applied

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    /* Problem: classes are not necessarily thread safe */
    if(l2.canBeNull != null)
        l2.cannotBeNull = l2.canBeNull //prevents to ensure thread safety

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    /* Solution */
    l2.cannotBeNull = l2.canBeNull ?: "fallback" //elvis operator with fallback value

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    /* Solution */
    l2.cannotBeNull = l2.canBeNull!! //not null assertion operator

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    /* Solution */
    if(l2.canBeNull != null)
        l2.cannotBeNull = l2.canBeNull as String //manual cast


    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    /* Solution - works for all nullable variables, not just instance variables */

    //Use null aware operator with "let" or "also"
    //Best option if avoiding an NPE and do not need a fallback value

    //l2.canBeNull is passed into the lambda if it is not null, making it into a parameter of type String and ensuring it can not be null inside the lambda

    l2.canBeNull?.let { l2.cannotBeNull = it } //uses the "it" keyword

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    l2.canBeNull?.let { it -> l2.cannotBeNull = it } //passing in "it" as a parameter

    l2.canBeNull?.let({ it -> l2.cannotBeNull = it }) //passing in the lambda as the last parameter of the function

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    //Jump to L3 Extension functions

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    //How to define a lambda
    val lambda1 = { item: String ->
        println(item)
        item.toLowerCase() //last line of a lambda is returned
    }

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////

    val modifyString = { itemA: String, paramLambda: (String) -> String ->
        paramLambda(itemA+"modified")
    }

    modifyString("test", lambda1) //using lambda1 defined above

    modifyString("test", { item -> item.toLowerCase() })

    modifyString("test") { item -> item.toLowerCase() } //lambda is last param so it can go outside the parenthesis

    modifyString("test") { it.toLowerCase() } //uses "it" keyword since the lambda has only 1 parameter

    ////////////////////////////////////////////////
    ///////////////////////////////////////////////
    ///////////////////////////////////////////////



}
