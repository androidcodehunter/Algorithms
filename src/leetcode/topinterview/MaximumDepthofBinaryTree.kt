package leetcode.topinterview

import tree.TreeNode
import kotlin.math.max

fun main(args: Array<String>) {

}

fun maxDepth(root: TreeNode?): Int {
    if (root == null)return 0

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)

    return max(left, right) + 1
}

var maxDepth = 0


fun iterativeMaxDepth(root: TreeNode?): Int{
    calculateMaxDepth(root, 1)
    return maxDepth
}

fun calculateMaxDepth(root: TreeNode?, depth: Int) {

    if (root == null)return

    if (maxDepth < depth) maxDepth = depth

    calculateMaxDepth(root.left, depth + 1)
    calculateMaxDepth(root.right, depth + 1)
}

