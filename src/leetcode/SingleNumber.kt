package leetcode

import kotlin.math.max


fun main(args: Array<String>) {
    //println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    //println(maxSubArray(intArrayOf(-2,-1)))
    //println(maxSubArray(intArrayOf(-1)))
   // println(maxSubArray(intArrayOf(-3, -1, -4)))
 ///  maxSubArray(intArrayOf(1, 2,-3,4,-1,7,1,-5,4))
    moveZeroes(intArrayOf(0,1,0,3,12))
    moveZeroes(intArrayOf(1))
    moveZeroes(intArrayOf(1,0,1))
}

fun moveZeroes(nums: IntArray): Unit {

  //  var zero = 0
/*
    for (i in nums.indices){
        if (nums[i] != 0){
            nums[zero++] = nums[i]
        }
    }

    for (i in zero until nums.size) nums[i] = 0*/

    //Optimal
    var nonZero = 0
    var i = 0
    while (i<nums.size){
        if (nums[i] != 0){
            val temp = nums[nonZero]
            nums[nonZero++] = nums[i]
            nums[i] = temp
        }
        i++
    }

    println(nums.joinToString())

}


fun moveZeroesOptimal(nums: IntArray){



    /*    for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.size(); cur++) {
        if (nums[cur] != 0) {
            swap(nums[lastNonZeroFoundAt++], nums[cur]);
        }
    }*/
}

fun maxSubArray(nums: IntArray): Int {


    if (nums.size == 1)return nums[0]

    var currentSum = 0
    var bestSum = 0

    nums.forEach {
        currentSum = max(0, currentSum + it)
        bestSum = max(bestSum, currentSum)
    }

    return bestSum
}


fun isHappy(n: Int): Boolean {

    if (n == 1)return true

    val set = mutableSetOf<Int>()

    var number = n

    while (number != 1){
        var digitsSum = 0
        while (number/10 > 0){
            val x = number%10
            digitsSum += x*x
            number /= 10
        }

        number = digitsSum

        if (set.contains(digitsSum)){
            return false
        }

        set.add(digitsSum)

    }

    return true


}

fun getDigits(n: Int): MutableList<Int> {
    val digits = mutableListOf<Int>()
    var result = n
    while (result > 0){
        digits.add(result % 10)
        result /= 10
    }
    return digits
}

fun singleNumber(nums: IntArray): Int {

    val sets = mutableMapOf<Int, Boolean>()

    nums.forEach {
        sets[it] = !sets.containsKey(it)
    }

    var result = 0
    sets.forEach { key, value ->
        if (value){
            result = key
            return@forEach
        }
    }
    return result
}