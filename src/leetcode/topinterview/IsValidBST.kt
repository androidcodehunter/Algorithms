package leetcode.topinterview

import tree.TreeNode
import java.util.*

fun main(args: Array<String>) {
  /*   val root = TreeNode(2)
   root.left = TreeNode(1)
   root.right = TreeNode(3)*/

/*    val root = TreeNode(0)
    root.left = TreeNode(-1)*/
/*    val root = TreeNode(5)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.right?.left = TreeNode(3)
    root.right?.right = TreeNode(6)*/


    val root = TreeNode(-2147483648)
    ///root.left = TreeNode(1)

    println(isValidBST(root))
}


fun isValidBST(root: TreeNode?): Boolean {


    val queue = Stack<TreeNode>()

    var myRoot = root
    var leftChildData = Long.MIN_VALUE

    while (queue.isNotEmpty() || myRoot != null){

        while (myRoot != null){
            queue.push(myRoot)
            myRoot = myRoot.left
        }

        myRoot = queue.pop()

        if (myRoot.data <= leftChildData)return false
        leftChildData = myRoot.data.toLong()
        myRoot = myRoot.right

    }

    return true
}
