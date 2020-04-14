package leetcode

import kotlin.math.max

/*
[0,1,0,1] = 4 // so this is 4, why?
[0,1,0,1,1] = 4 // this is also 4... so there is some symetry condition??
[0,0,1,0,0,0,1,1] = 6 // this is 6?? I do not see why. I would have expected 4
[0,1,0,1] is 4 because 2 pairs - 01 and 01 and they're going together 0101 - the length of this is 4
[0,]
[-1, -2, -1, -2, -3, -4, -3, -2]
[ 0,  0,  1,  0,  0,  0,  1,  1] is 6 - 100011 - sum is 0 and it's continious.
//
index
[ 0, 1, 2, 3, 4, 5, 6, 7]
[-1, 0, 1, 0, 1, 2, 3, 2]
[ 0, 1, 1, 0, 1, 1, 1, 0] expected 4
*/

fun main(args: Array<String>) {
    println(findMaxLength(intArrayOf(0,1)))//2
    println(findMaxLength(intArrayOf(0,1,0)))//2
    println(findMaxLength(intArrayOf(0,1,0,0,0)))//2
    println(findMaxLength(intArrayOf(1,0,1)))//2
    println(findMaxLength(intArrayOf(0,0,0,1,1,0,1,0, 0, 0)))//6

    println(findMaxLength(intArrayOf(0,0,1,0,0,0,1,1)))//6
}

fun findMaxLength(nums: IntArray): Int {
    var maxCount = 0
    var count = 0
    val counts = mutableMapOf<Int, Int>()
    counts[0] = -1

    nums.forEachIndexed { index, data ->
        if (data == 0 ){
            count--
        }else{
            count++
        }
        if (counts.containsKey(count)){
            maxCount = max(maxCount, index - (counts[count] ?: 0))
        }else{
            counts[count] = index
        }

    }

    return maxCount
}