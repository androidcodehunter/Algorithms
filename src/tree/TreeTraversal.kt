package tree

import java.util.*


fun main(args: Array<String>) {

    val root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(4)

    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(0)

    root.right?.right = TreeNode(2)

    preorderTraversal(root)
}

fun preorderTraversal(root: TreeNode){

    val stack = Stack<TreeNode>()
    stack.push(root)

    while (stack.isNotEmpty()){

        val top = stack.pop()
        println(top.data)

        if (top.right != null)stack.push(top.right)

        if (top.left != null){
            stack.push(top.left)
        }
    }

}

fun inorderTraversal(root: TreeNode){

    val stack = Stack<TreeNode>()
    stack.push(root)

    while (stack.isNotEmpty()){

    }

}
