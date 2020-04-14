package leetcode.thirtydays

import java.util.*

fun main(args: Array<String>) {
    println(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))

    val heap = PriorityQueue<Int>(Collections.reverseOrder())
    heap.add(10)
    heap.add(101)
    heap.add(1)
    heap.add(11)
    heap.add(201)
    heap.add(2)
    heap.add(200)
    println(heap.poll())
    println(heap.poll())
}


fun lastStoneWeight(stones: IntArray): Int {
    if (stones.size == 1){
        return stones[0]
    }
    if (stones.isEmpty())return 0

    val list = stones.toMutableList()
    list.sort()
    val first = list[list.size-1]
    val second = list[list.size-2]

    list.removeAt(list.size -1)
    list.removeAt(list.size - 1)

    if (first != second){
        list.add(first - second)
    }
    return lastStoneWeight(list.toIntArray())
}