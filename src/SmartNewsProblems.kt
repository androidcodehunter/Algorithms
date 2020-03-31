fun main(args: Array<String>) {
    println(smartNewsSolutionOne(intArrayOf(1,4,7,3,3,5)))
    println(smartNewsSolutionOne(intArrayOf(0,3,3,7,5,3,11,1)))
    println(smartNewsSolutionTwo(intArrayOf(4,2,2,4,2)))
    println(smartNewsSolutionTwo(intArrayOf(1,2,3,2)))
    println(smartNewsSolutionTwo(intArrayOf(0,5,4,4,5,12)))
    println(smartNewsSolutionTwo(intArrayOf(4,4)))
}


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

            if (count > 1){
                diff = (set[list[i + 1].second] ?: 0) - list[i].second
            }else{
                diff = list[i + 1].second - list[i].second
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
