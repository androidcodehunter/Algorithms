package leetcode.thirtydays

fun main(args: Array<String>) {
    println(search(intArrayOf(4,5,6,7,0,1,2), 2))
    println(search(intArrayOf(1,3), 0))
}

fun search(nums: IntArray, target: Int): Int {

    if (nums.isEmpty())return -1

    var left = 0
    var right = nums.size - 1

    // you have to find the pivot using binary search as well.
    while (left < right){
        val middle = left + (right - left)/2
        if (nums[middle] == target){
            return middle
        } else if (nums[middle] > nums[right]){
            left = middle + 1
        }else{
            right = middle
        }
    }

    val start = left

    left = 0
    right = nums.size - 1

    if (target >= nums[start] && target <= nums[right]){
        left = start
    }else{
        right = start
    }


    while (left <= right){
        val middle = left + (right - left)/2

        if (nums[middle] == target){
            return middle
        } else if (nums[middle] < target){
            left = middle + 1
        }else{
            right = middle - 1
        }
    }


    return -1
}