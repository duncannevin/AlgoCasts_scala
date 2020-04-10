package linkedlist

class Node[T](val data: T) {
  private var next: Node[T] = _

  def setNext(newNode: Node[T]): Unit = next = newNode

  def getNext: Node[T] = next
}
