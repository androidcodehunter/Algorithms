package leetcode.thirtydays

import java.lang.Integer.max

fun main(args: Array<String>) {
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(maxSubArray(intArrayOf(-1)))
}

fun maxSubArray(nums: IntArray): Int {
    var bestSum = Int.MIN_VALUE
    var currentSum = 0

    nums.forEach {
        currentSum += it
        bestSum = max(currentSum, bestSum)
        currentSum = max(currentSum, 0)
    }

    return bestSum
}