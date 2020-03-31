package graph

fun main(args: Array<String>) {
    var isLandCount = numIslands(arrayOf(
        intArrayOf(1,1,1,1,0),
        intArrayOf(1,1,0,1,0),
        intArrayOf(1,1,0,0,0),
        intArrayOf(0,0,0,0,0)
    ))
    println(isLandCount)

    isLandCount = numIslands(arrayOf(
        intArrayOf(1,1,0,0,0),
        intArrayOf(1,1,0,0,0),
        intArrayOf(0,0,1,0,0),
        intArrayOf(0,0,0,1,1)
    ))
    println(isLandCount)

}

fun numIslands(grid: Array<IntArray>): Int {
    var countIsland = 0
    for (row in grid.indices){
        for (column in grid[row].indices){
            if (grid[row][column] == 1){
                println("point ($row, $column) ->")
                countIsland(grid, row, column)
                countIsland++
            }
        }
    }
    return countIsland
}

fun countIsland(grid: Array<IntArray>, row: Int, column: Int) {

    if (row < 0 || column < 0 || row >= grid.size || column >= grid[row].size)
        return

    if (grid[row][column] == 0)
        return

    grid[row][column] = 0
    ///println("${grid.contentDeepToString()}, $row $column")
    countIsland(grid, row - 1, column)
    countIsland(grid, row + 1, column)
    countIsland(grid, row, column - 1)
    countIsland(grid, row, column + 1)

}
