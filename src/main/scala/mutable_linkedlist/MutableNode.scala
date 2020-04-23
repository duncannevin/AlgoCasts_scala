package mutable_linkedlist

class MutableNode[T](val data: T) {
  private var next: MutableNode[T] = _

  def setNext(newNode: MutableNode[T]): Unit =
    next = newNode

  def getNext: MutableNode[T] = next
}
