package leetcode.topinterview


fun main(args: Array<String>) {
    println(removeDuplicates(intArrayOf(1,1,2)))
    println(removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4)))
}

fun removeDuplicates(nums: IntArray): Int {
    var count = 1

    var index = 1
    for (i in 0..nums.size-2){
        if (nums[i] != nums[i+1]){
            nums[index++] = nums[i+1]
            count++
        }
    }

   /// println(nums.joinToString (""))
    return count
}