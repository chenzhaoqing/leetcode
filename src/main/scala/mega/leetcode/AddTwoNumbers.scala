/**
  * Created by ChenZhaoqing on 2018/11/30.
  */
package mega.leetcode



object AddTwoNumbers {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {

    var resultList: ListNode = null
    var p: ListNode = null
    var p1 = l1
    var p2 = l2

    var carry = 0
    while (p1 != null || p2 != null || carry != 0) {
      var sum = carry
      if (p1 != null) {
        sum += p1._x
        p1 = p1.next
      }

      if (p2 != null) {
        sum += p2._x
        p2 = p2.next
      }

      carry = sum / 10


      if (resultList == null) {
        resultList = new ListNode(sum % 10)
        p = resultList
      } else {
        p.next = new ListNode(sum % 10)
        p = p.next
      }

    }
    resultList
  }

}