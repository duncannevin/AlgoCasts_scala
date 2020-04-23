package linkedlist

trait LinkedListImpl[T] {
  def insertFirst(data: T): LinkedList[T]
  def size: Int
  def head: Node[T]
  def last: Node[T]
  def clear: LinkedList[T]
  def tail: LinkedList[T]
  def init: LinkedList[T]
  def push(data: T): LinkedList[T]
  def getAt(index: Int): Node[T]
}

class LinkedList[T](private val src: Node[T] = null) extends LinkedListImpl[T] {

  def insertFirst(data: T): LinkedList[T] = new LinkedList[T](
    src match {
      case null => Node(data, null)
      case node: Node[T] => Node(data, node)
    }
  )

  def size: Int = size()
  @scala.annotation.tailrec
  private def size(count: Int = 0, node: Node[T] = src): Int = node match {
    case null => count
    case Node(_, next) => size(count + 1, next)
  }

  def head: Node[T] = src

  def last: Node[T] = last()
  @scala.annotation.tailrec
  private def last(node: Node[T] = src): Node[T] = node.next match {
    case null => node
    case _ => last(node.next)
  }

  def clear: LinkedList[T] = new LinkedList[T]

  def tail: LinkedList[T] = head match {
    case null => this
    case Node(_, next) => new LinkedList[T](next)
  }

  def init: LinkedList[T] = ???

  def push(data: T): LinkedList[T] = ???

  def getAt(index: Int): Node[T] = ???
}
