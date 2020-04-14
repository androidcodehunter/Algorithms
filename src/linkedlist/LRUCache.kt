package linkedlist

import java.util.*

class LRUCache(var capacity: Int){

    val map = mutableMapOf<Int, Node>()

    private val dQueue: Deque<Node> = LinkedList()

    /*Get the value from memory*/
    fun get(key: Int): Int {
        return 0
    }

    /**/
    fun put(key: Int, value: Int) {
        var node: Node? = null
        if (map.contains(key)){
            var i = 0
            dQueue.forEach {
                if (it.key == key){
                    node = it
                }
                i++
            }
            //Getting the node from hashmap then remove it from dequeue
            dQueue.remove(node)
        }else{
            if (dQueue.size == capacity){
                dQueue.removeLast()
                map.remove(key)
            }
        }
        dQueue.push(node)
        map[key] = node!!
    }

}

data class Node(var key: Int, var value: Int)