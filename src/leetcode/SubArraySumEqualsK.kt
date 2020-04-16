package leetcode

import java.lang.Integer.max
import kotlin.math.abs

fun main(args: Array<String>) {
    println(subarraySum(intArrayOf(1,1,1), 2))//3
   // println(subarraySum(intArrayOf(-1,-1,1), 0))//1
    println(subarraySum(intArrayOf(100,1,2,3,1), 6))//1
    println(subarraySum(intArrayOf(1,2,3,4,5,6,0,7,1,23,21,3,1,2,1,1,1,1,1,12,2,3,2,3,2,2), 6))//6
  //  println(subarraySum(intArrayOf(0,6,0,7,1,23,21,3,1,2,1,1,1,1,1,12,2,3,2,3,2,2), 6))//6
   // println(subarraySum(intArrayOf(6,0,7,1,23,21,3,1,2,1,1,1,1,1,12,2,3,2,3,2,2), 6))//6
}
/**/
fun subarraySum(nums: IntArray, k: Int): Int {

    var subArraySumCount = 0
    var currentSum = 0

    var start = 0
    var current = 0

    while (start < nums.size && current < nums.size){

        currentSum += nums[current]

        if (currentSum == k){
         ///   println("start $start")
            currentSum -= nums[start]
            start++
            current++
            subArraySumCount++
            continue
        }

        if (currentSum < k){
            current++
        }else{
            //start and sum refresh
            start++
            current++
            currentSum = 0
        }




    }


    return subArraySumCount
}