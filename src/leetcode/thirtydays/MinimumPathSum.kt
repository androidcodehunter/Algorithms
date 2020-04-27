package leetcode.thirtydays

import kotlin.math.min

fun main(args: Array<String>) {

    println(minPathSum(arrayOf(intArrayOf(1,3,1), intArrayOf(1,5,1), intArrayOf(4,2,1))))

}

fun minPathSum(grid: Array<IntArray>): Int {

    for (i in grid.indices){

        for (j in grid[i].indices){

            val current = grid[i][j]
            //Top left
            if (i > 0 && j>0){
                grid[i][j] = min(current + grid[i-1][j], current + grid[i][j-1])
            }else if (i == 0 && j > 0){
                grid[i][j] = current + grid[i][j-1]
            }else if (j == 0 && i >0){
                grid[i][j] = current + grid[i-1][j]
            }
        }
    }

    return grid[grid.size-1][grid[0].size-1]
}