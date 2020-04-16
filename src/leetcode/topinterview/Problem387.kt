package leetcode.topinterview

fun main(args: Array<String>) {
    println(firstUniqChar("loveleetcode"))
}

/*s = "leetcode"
return 0.

s = "loveleetcode",
return 2.*/
fun firstUniqChar(s: String): Int {

    val map = linkedMapOf<Char, MyPair>()
    s.forEachIndexed { index, data ->
        if (map.containsKey(data)){
            val pair = map[data]
            pair?.isExist = false
            pair?.let {
                map[data] = it
            }
        }else{
            map[data] = MyPair(index, true)
        }
    }

    for ((k, v) in map) {
        if (v.isExist) return v.index
    }

    return -1
}

data class MyPair(var index: Int, var isExist: Boolean)
