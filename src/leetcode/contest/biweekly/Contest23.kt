package leetcode.contest.biweekly

fun main(args: Array<String>) {
    println(backspaceCompare("ab#c", "ad#c"))

    println(backspaceCompare("ab##", "c#d#"))


    println(backspaceCompare("a##c", "#a#c"))
}

fun backspaceCompare(S: String, T: String): Boolean {
    val listOne = mutableListOf<Char>()
    val listTwo = mutableListOf<Char>()

    S.forEach{
        if(it != '#'){
            listOne.add(it)
        }else{
            if(listOne.isNotEmpty())listOne.removeAt(listOne.size-1)
        }
    }


    T.forEach{
        if(it != '#'){
            listTwo.add(it)
        }else{
            if(listTwo.isNotEmpty())listTwo.removeAt(listTwo.size-1)
        }
    }

    return listOne.toString() == listTwo.toString()

}


fun plusOne(digits: IntArray): IntArray {
    val data = digits.joinToString().toInt() + 1
    val result = data.toString()
    val array = IntArray(result.length)
    var i = 0
    result.forEach{
        array[i] = it.toString().toInt()
        i++
    }

    return array
}




fun maxProfit(prices: IntArray): Int {
    //[7,1,5,3,6,4]
    // [7,6,4,3,1]
    //[1,2,3,4,5]
    //[7,1,5,6,2,4]
    var maxProfit = 0
    for(i in 1 until prices.size){
        if(prices[i] > prices[i -1])maxProfit += prices[i] - prices[i-1]
    }

    return maxProfit
}




fun countLargestGroup(n: Int): Int {
    val map = mutableMapOf<Int, Int>()
    for (i in 1..n){
        var sum = i.toString().map { it.toString().toInt() }.sum()
        map[sum] = (map[sum]?: 0) + 1
    }
    val data  = map.asSequence().groupBy { it.value }.maxBy { it.key }?.value?.size

    return data ?: 0
}

fun longestCommonPrefix(strs: Array<String>): String {

    var prefix = ""

    var first = strs[0]
    var result = ""
    for(i in 1 until strs.size){

        val data = strs[i]
        result= ""
        var i = 0
        var j = 0

        while(i<first.length && j<data.length){

            if(data[i] != first[j]){
                break
            }else{
                result += data[i]
            }

            i++
            j++
        }
        first = result
        if (result.isEmpty())return result


    }

    prefix = result
    return prefix
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    var i = 0
    var result = IntArray(2)
    nums.forEach{

        val search = target - it

        if (map.containsKey(search)){
            result[0] = map[search]?:0
            result[1] = i
        }else{
            map[it] = i
        }
        i++
    }
    return result
}




