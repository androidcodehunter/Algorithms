package leetcode.thirtydays

fun main(args: Array<String>) {
    var rootNode = TreeNode(1)
    rootNode.left = TreeNode(3)
    rootNode?.left?.left = TreeNode(4)
    rootNode?.left?.right = TreeNode(5)
    rootNode.right = TreeNode(2)
    diameterOfBinaryTree(rootNode)
}

fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null)return 0

    println("before root ${root.data}")
    var left = diameterOfBinaryTree(root.left)
    println("middle root ${root.data}")
    var right = diameterOfBinaryTree(root.right)
    println("after root ${root.data}")

return 1
}

class TreeNode(var data: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
     }