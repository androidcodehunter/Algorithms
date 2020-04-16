package leetcode.thirtydays

import java.util.*

fun main(args: Array<String>) {

    println(checkBalanceValidString("((*)"))
    println(checkBalanceValidString("(((((()*)(*)*))())())(()())())))((**)))))(()())()"))
    println( checkBalanceValidString(")"))
    println(checkBalanceValidString("(*)"))
    println(checkBalanceValidString("((*)))))"))
    println(checkBalanceValidString("*"))
    println(checkBalanceValidString(")("))

}

fun checkBalanceValidString(s: String): Boolean {

    var leftBalance = 0
    s.forEach {
        if (it == ')'){
            leftBalance--
        } else{
            leftBalance++
        }

        if (leftBalance < 0)return false
    }

    if (leftBalance == 0)return true


    var rightBalance = 0
    s.reversed().forEach {
        if (it == '(')rightBalance-- else rightBalance++

        if (rightBalance < 0)return false
    }

    return true
}

fun checkValidString(s: String): Boolean {

    if (s.isEmpty() || s == "*") return true
    if(s == ")")return false

    val stackLeft = Stack<Char>()
    val stackRight = Stack<Char>()
    val stack = Stack<Char>()

    s.forEach {
        if (it == '('){
            stack.push(it)
           // stackLeft.push(it)
           // stackRight.push(it)
        }else if (it == ')'){
            //if (!stackLeft.isEmpty())stackLeft.pop()
           // if (!stackRight.isEmpty())stackRight.pop()
            if (!stack.isEmpty())stack.pop()
        }else{
           // stackLeft.push('(')
            ///stackRight.push(')')
          //  if (!stackRight.isEmpty())stackRight.pop()
        }
    }

    println(stack.toString())
   // println(stackLeft.toString())
   // println(stackRight.toString())

    if (stack.isEmpty())return true

    ///if (stackLeft.isEmpty() || stackRight.isEmpty())return true

    return false
}