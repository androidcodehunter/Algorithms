package leetcode.topinterview

import tree.TreeNode
import java.util.*

fun main(args: Array<String>) {

}

fun levelOrder(root: TreeNode?): List<List<Int>> {

    val list = mutableListOf<MutableList<Int>>()

    if (root == null)return list


    val queue = LinkedList<TreeNode>()
    queue.add(root)

    while (queue.isNotEmpty()){
        val currentList = mutableListOf<Int>()
        val size = queue.size

        for (i in 0 until size){
            val top = queue.remove()
            currentList.add(top.data)
            if (top.left != null) queue.add(top.left)
            if (top.right != null) queue.add(top.right)
        }

        list.add(currentList)
    }

    return list
}