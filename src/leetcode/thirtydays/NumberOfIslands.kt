package leetcode.thirtydays

import java.util.*

fun main(args: Array<String>) {

    ////   int modGroup(int m) {int r = 1; for (int i = 10; i != 1 && r < m; i = (i * 10) % m) r++; return r; }

    //Break p into r pieces using modulo arithmetic, and sum the pieces. Try smaller pieces until you find the minimum. Not sure how to best choose a dividend, but apparently my method was good enough.

    // println(numIslands(arrayOf(charArrayOf('1','1','1','1','0'), charArrayOf('1','1','0','1','0'), charArrayOf('1','1','0','0','0'), charArrayOf('0','0','0','0','0'))))
  /*  println(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
        )
    )*/
/*3 => 1
11 => 2
7 => 6
211 => 30
999982 => 999982*/
    println(inGroup(3))
    println(inGroup(11))
    println(inGroup(7))
    println(inGroup(211))
    println(inGroup(999982))
}

fun inGroup(m: Int): Int{

    var r = 1
    var i = 10

    while (i !=1 && r<m){
        i = (i*10) % m
        r++
    }

    return r

}

///fun numIslands(grid: Array<CharArray?>?): Int {}

fun numIslands(grid: Array<CharArray>): Int {


    if (grid.isNullOrEmpty()) return 0

    var countIsland = 0

    val stack = Stack<Pair<Int, Int>>()

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == '1') {

                stack.push(Pair(i, j))

                while (stack.isNotEmpty()) {

                    val root = stack.pop()

                    val x = root.first
                    val y = root.second

                    grid[root.first][root.second] = '0'


                    //left, right, top, bottom push into stack

                   /// println("x $x, y $y")

                    if (x < grid.size -1 && (grid[x + 1][y] == '1')) {
                        stack.push(Pair(x + 1, y))
                    }

                    if (x > 0 && grid[x - 1][y] == '1') {
                        stack.push(Pair(x - 1, y))
                    }

                    if (y < grid[x].size-1 && grid[x][y + 1] == '1') {
                        stack.push(Pair(x, y + 1))
                    }

                    if (y > 0 && grid[x][y - 1] == '1') {
                        stack.push(Pair(x, y - 1))
                    }

                    //   }

                }


                ///  printGrid(grid)
                countIsland++
            }

        }
    }

    return countIsland
}

fun printGrid(grid: Array<IntArray>) {
    for (i in grid.indices) {
        println(grid[i].joinToString(""))
    }
}