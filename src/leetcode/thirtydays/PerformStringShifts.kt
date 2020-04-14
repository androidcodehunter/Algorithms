package leetcode.thirtydays

fun main(args: Array<String>) {
    println(stringShift("abc", arrayOf(intArrayOf(0,1), intArrayOf(1,2))))
}

fun stringShift(s: String, shift: Array<IntArray>): String {
    val list = s.toCharArray().toMutableList()
    val builder = StringBuilder()
    shift.forEach {
        val leftRight = it[0]
        val shiftCount = it[1]
        builder.clear()
        if (leftRight == 0){
            //left shift
            for (i in 1..shiftCount){
                builder.append(list[0])
                list.removeAt(0)
            }
            builder.toString().forEach {char ->
                list.add(char)
            }
        }else{
            for (i in 1..shiftCount){
                builder.append(list[list.size-1])
                list.removeAt(list.size-1)
            }
            builder.toString().forEach {char ->
                list.add(0, char)
            }
        }
    }
    return list.joinToString("")
}
