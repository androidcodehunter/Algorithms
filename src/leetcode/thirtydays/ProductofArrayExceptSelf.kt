package leetcode.thirtydays

fun main(args: Array<String>) {

    productExceptSelf(intArrayOf(1,2,3,4)).forEach {
        println(it)
    }

    productExceptSelf(intArrayOf(1,0)).forEach {
        println(it)
    }
}


fun productExceptSelf(nums: IntArray): IntArray {

    var product = 1
    var zeroCount = 0

    nums.forEach {
        if (it != 0) product *=it else zeroCount++
    }

    nums.forEachIndexed { index, data ->
        if (zeroCount > 1){
            nums[index] = 0
        }else if (zeroCount == 1){
            if (nums[index] == 0){
                nums[index] = product
            }else{
                nums[index] = 0
            }
        }else{
            nums[index] = product/nums[index]
        }
    }

    return nums
}