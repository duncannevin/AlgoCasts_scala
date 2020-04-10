package linkedlist

class LinkedList[T] {
  private var head: Node[T] = _

  def insertFirst(data: T): Unit = head match {
    case null => head = new Node[T](data)
    case _ =>
      val newNode = new Node[T](data)
      newNode.setNext(head)
      head = newNode
  }

  def size: Int = size()

  @scala.annotation.tailrec
  private def size(count: Int = 0, node: Node[T] = head): Int = node match {
    case null => count
    case n => size(count + 1, n.getNext)
  }

  def getHead: Node[T] = head
}
