package graph
//Hackerrank Solution: https://www.youtube.com/watch?v=R4Nh-EgWjyQ
//val board = Array(n, { IntArray(n) })
//DFS is easier to implement
fun biggestRegion(matrix: Array<IntArray>){

    var visited = array2dOfBoolean(matrix.size, matrix[0].size)

    for (row in matrix.indices){
        for (column in matrix[row].indices){
            if (matrix[row][column] == 1){
              ///  println("value 1 index $row $column")
                var size = getRegionSize(matrix, row, column)
                println(size)
            }
        }
    }

}

fun getRegionSize(matrix: Array<IntArray>, row: Int, column: Int): Int {
    //safety check
    if (row < 0 || column < 0 || row >= matrix.size || column >= matrix[0].size)
        return 0

    if (matrix[row][column] == 0)
        return 0

    matrix[row][column] = 0

    var size = 1

    for (r in row-1..row+1){
        for (c in column -1 .. column + 1){
            size += getRegionSize(matrix, r, c)
        }
    }

    return size
}

fun main(args: Array<String>) {

    biggestRegion(arrayOf(
        intArrayOf(0,0,0,1,1,0,0),
        intArrayOf(0,1,0,0,1,1,0),
        intArrayOf(1,1,0,1,0,0,1),
        intArrayOf(0,0,0,0,0,1,0),
        intArrayOf(1,1,0,0,0,0,0),
        intArrayOf(0,0,0,1,0,0,0)
    ))
}


public inline fun <reified INNER> array2d(sizeOuter: Int, sizeInner: Int, noinline innerInit: (Int)->INNER): Array<Array<INNER>>
        = Array(sizeOuter) { Array<INNER>(sizeInner, innerInit) }
public fun array2dOfInt(sizeOuter: Int, sizeInner: Int): Array<IntArray>
        = Array(sizeOuter) { IntArray(sizeInner) }
public fun array2dOfLong(sizeOuter: Int, sizeInner: Int): Array<LongArray>
        = Array(sizeOuter) { LongArray(sizeInner) }
public fun array2dOfByte(sizeOuter: Int, sizeInner: Int): Array<ByteArray>
        = Array(sizeOuter) { ByteArray(sizeInner) }
public fun array2dOfChar(sizeOuter: Int, sizeInner: Int): Array<CharArray>
        = Array(sizeOuter) { CharArray(sizeInner) }
public fun array2dOfBoolean(sizeOuter: Int, sizeInner: Int): Array<BooleanArray>
        = Array(sizeOuter) { BooleanArray(sizeInner) }


