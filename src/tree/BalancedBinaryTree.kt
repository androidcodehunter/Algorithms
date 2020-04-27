package tree

import kotlin.math.abs
import kotlin.math.max

fun main(args: Array<String>) {

}


var isBalanced = true

fun isBalanced(root: TreeNode?): Boolean {

    checkLeftAndRight(root)

    return isBalanced
}

fun checkLeftAndRight(root: TreeNode?): Int {
    if (root == null)return 0

    val left = checkLeftAndRight(root.left)
    val right = checkLeftAndRight(root.right)

    val diff = abs(left - right)

    if (diff > 1) isBalanced = false
    return max(left, right) + 1
}
