package leetcode.thirtydays

fun main(args: Array<String>) {
    groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).forEach {
        println(it)
    }
}

/*Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]*/
fun groupAnagrams(strs: Array<String>): List<List<String>> {

  val map = mutableMapOf<String, MutableList<String>>()

    strs.forEach {
        val sortedData = it.toCharArray().sorted().toString()
        if (map.containsKey(sortedData)){
            val list = map[sortedData]
            list?.add(it)
            map[sortedData] = list!!
        }else{
            val list = mutableListOf<String>()
            list.add(it)
            map[sortedData] = list
        }
    }

    val list = mutableListOf<List<String>>()

    map.forEach {
        list.add(it.value)
    }

    return list
}