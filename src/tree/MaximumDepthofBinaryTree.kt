package tree

import kotlin.math.max

fun main(args: Array<String>) {
    val root = TreeNode(5)
    root.left = TreeNode(3)
    root.right = TreeNode(4)

    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(0)

    root.right?.right = TreeNode(2)

    println(maxDepth(root))
}

/*     5
*    3   4
*  1  0    2
*
* */


fun maxDepth(root: TreeNode?): Int{

    if (root == null)return 0

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)


    return max(left, right) + 1
}

/*left 0 data 1
left 1 data 3
left 2 data 5*/
