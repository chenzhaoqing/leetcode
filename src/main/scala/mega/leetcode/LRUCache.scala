/**
  * Created by ChenZhaoqing on 2018/11/28.
  */
package mega.leetcode


class LRUCache(_capacity: Int) {
  case class Node(key: Int, value: Int, var prev: Node = null, var next: Node = null)
  var head = Node(-1, -1)
  var tail = Node(-1, -1, head)
  head = head.copy(next = tail)
  val cache = scala.collection.mutable.Map.empty[Int, Node]
  var size = 0

  def get(key: Int): Int = {
    cache.get(key) match {
      case Some(node) =>
        removeFromList(node)
        addToListHead(node)
        node.value
      case None => -1
    }
  }

  def put(key: Int, value: Int): Unit = {
    val node = Node(key, value)
    cache.get(key).fold {
      if (size == _capacity) {
        cache.remove(tail.prev.key)
        removeFromList(tail.prev)

      } else {
        size += 1
      }

      cache.update(key, node)
      addToListHead(node)

    } {
      current =>
        removeFromList(current)
        cache.update(key, node)
        addToListHead(node)
    }
  }

  def removeFromList(node: Node): Unit = {
    node.prev.next = node.next
    node.next.prev = node.prev
  }

  def addToListHead(node: Node): Unit = {
    node.next = head.next
    node.prev = head
    head.next.prev = node
    head.next = node
  }

}
