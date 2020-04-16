package leetcode.thirtydays

import java.util.*

fun main(args: Array<String>) {
   // println( checkValidString("()"))
   // println( checkValidString("(*)"))
   // println( checkValidString("(*))"))
    println(checkValidString("(*)("))
    println( checkValidString("((*)"))
   // println( checkValidString("((*)))))"))
}

fun checkValidString(s: String): Boolean {
    val stackOne = Stack<Char>()

    var starCount = 0

    s.forEach {
        if (it == '('){
            stackOne.push(it)
        }else if (it == ')'){
            if (stackOne.isEmpty() && starCount > 0){
                starCount--
            }else{
                stackOne.pop()
            }
        }

        if (it == '*'){
            starCount++
        }
    }

    println(stackOne.toString())

    return stackOne.isEmpty()
}