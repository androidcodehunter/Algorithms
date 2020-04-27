package leetcode.thirtydays

import java.util.*


fun main(args: Array<String>) {
    val lruCache = LRUCache(2)
    println(lruCache.get(2))
    lruCache.put(2,6)
    println(lruCache.get(1))
    lruCache.put(1,5)
    lruCache.put(1,2)
    println(lruCache.get(1))
    println(lruCache.get(2))
   /* Input:
    ["LRUCache","get","put","get","put","put","get","get"]
    [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
    Output:
    [null,-1,null,-1,null,null,2,-1]
    Expected:
    [null,-1,null,-1,null,null,2,6]*/
}

class LRUCache(val capacity: Int) {

    var doublyLinkedList = LinkedList<Node>()
    val map = mutableMapOf<Int, Node>()

    fun get(key: Int): Int {
        //remove the key data from linkedlist
        //add this to first in doubly linkedlist
        //return the value
        if (map.containsKey(key)){
            val node = map[key]
            doublyLinkedList.remove(node)
            doublyLinkedList.addFirst(node)
            return node?.data!!
        }else{
            return -1
        }
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)){
            var myNode = map[key]
            doublyLinkedList.remove(myNode)
            myNode?.data = value
            map[key] = myNode!!
            doublyLinkedList.addFirst(myNode)
        }else if (doublyLinkedList.size >= capacity){
            val data = Node(value, key)
            val removedData = doublyLinkedList.removeLast()
            map.remove(removedData.key)
            doublyLinkedList.addFirst(data)
            map[key] =data
        }else{
            val node = Node(value, key)
            doublyLinkedList.addFirst(node)
            map[key] = node
        }
    }

}

data class Node(var data: Int, val key: Int)