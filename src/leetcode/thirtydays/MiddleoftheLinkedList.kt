package leetcode.thirtydays

fun main(args: Array<String>) {
    var head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next?.next = ListNode(6)

    println(middleNodeSlowFast(head)?.data)
   // println(middleNode(head)?.data)
}


//[1,2,3,4,5]
fun middleNode(head: ListNode?): ListNode? {
    var count = 0

    var current = head

    while (current != null){
        count++
        current = current.next
    }

    current = head
    count /=2

    var i = 0
    var middle: ListNode? = null
    while (i<=count){
        middle = current
        current = current?.next
        i++
    }
    return middle
}

fun middleNodeSlowFast(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    while (fast?.next != null){
        slow = slow?.next
        fast = fast?.next?.next
    }
    return slow
}

data class ListNode(val data: Int){
    var next: ListNode? = null
}