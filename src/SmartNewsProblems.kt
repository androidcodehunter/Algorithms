import java.util.*

fun main(args: Array<String>) {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring("aab"))
    println(lengthOfLongestSubstring(" "))
    println(lengthOfLongestSubstring("dvdf"))
    
}

fun lengthOfLongestSubstring(s: String): Int {
    val set = mutableSetOf<Char>()
    var count = 0
    s.forEach{
        if(set.contains(it)){
            val len = set.joinToString("").length
            if (len > count) count = len
            set.remove(it)
            set.add(it)
        }else{
            set.add(it)
            val len = set.joinToString("").length
            if (len > count){
                count = len
            }
        }
    }

    return count
}


//solution may be here https://adaguo.wordpress.com/2013/08/19/compute-adjacent-pair/
fun smartNewsSolutionOne(A: IntArray): Int {
    // write your code in Kotlin

    val list = mutableListOf<Pair<Int, Int>>()

    val indexCount = mutableMapOf<Int, Int>()
    val set = mutableMapOf<Int, Int>()

    A.forEachIndexed { index, value ->
        list.add(Pair(value, index))
        indexCount[value] = (indexCount[value] ?: 0) + 1
        set[value] = index
    }

    list.sortBy { it.first }

    var result = -1
    for (i in list.indices - 1){
        val current = list[i].first
        val next = list[i + 1].first

        var diff = 0
        if (current != next && current + 1 < next){

            val count = indexCount[next]?:1

            diff = if (count > 1){
                (set[list[i + 1].first] ?: 0) - list[i].second
            }else{
                list[i + 1].second - list[i].second
            }
            return Math.abs(diff)
        }
    }


    return result

}


/*Longest Bi valued slice*/
fun smartNewsSolutionTwo(A: IntArray): Int {
    // write your code in Kotlin

    if (A.isEmpty())return -1

    val countMap = mutableMapOf<Long, Long>()
    A.forEach {
        countMap[it.toLong()] = (countMap[it.toLong()] ?: 0L) + 1L
    }

    return if (countMap.size <= 2){
        A.size
    }else{
        val sortedList = countMap.toList()
            .sortedBy { (key, value) -> value }
            .toList()
        val size = sortedList.size
        val result = sortedList[size-1].second + sortedList[size-2].second
        result.toInt()
    }
}
