package linkedlist

class LinkedList[T] {
  private var head: Node[T] = _
  private var nodeCount: Int = 0

  def insertFirst(data: T): Unit = incNodeCount { _ => {
      head match {
        case null =>
          head = new Node[T](data)
        case _ =>
          val newNode = new Node[T](data)
          newNode.setNext(head)
          head = newNode
      }
    }
  }

  def size: Int = nodeCount

  // Slow implementation, replaced by tracking size when items are added and removed
  @scala.annotation.tailrec
  private def size(count: Int = 0, node: Node[T] = head): Int = node match {
    case null => count
    case n => size(count + 1, n.getNext)
  }

  def getFirst: Node[T] = head

  def getLast: Node[T] = {
    if (head == null || head.getNext == null) return head
    getAt(nodeCount - 1)
  }

  def clear(): Unit = clearNodeCount { _ =>
    head = null
  }

  def removeFirst(): Unit = decNodeCount { _ => {
      val newFirst = head.getNext
      head = newFirst
    }
  }

  def removeLast(): Unit = decNodeCount { _ =>
    if (head == null || size() == 1) {
      head = null
    } else {
      val newLast = getAt(size() - 2)
      newLast.setNext(null)
    }
  }

  def insertLast(data: T): Unit = {
    val newNode = new Node[T](data)

    if (head == null) {
      head = newNode
    } else {
      val last = getLast
      last.setNext(newNode)
    }

    incNodeCount()
  }

  def getAt(index: Int): Node[T] = getAt(index, head)

  @scala.annotation.tailrec
  private def getAt(index: Int, node: Node[T]): Node[T] = index match {
    case 0 => node
    case ind if ind < 0 => null
    case _ =>
      getAt(index - 1, node.getNext)
  }

  private def incNodeCount(): Unit = incNodeCount(_ => {})

  private def incNodeCount(continue: Int => AnyVal): Unit = {
    nodeCount = nodeCount + 1
    continue(nodeCount)
  }

  private def decNodeCount(): Unit = decNodeCount(_ => {})

  private def decNodeCount(continue: Int => AnyVal = _ => {}): Unit = {
    if (nodeCount > 0) {
      nodeCount = nodeCount - 1
    }
    continue(nodeCount)
  }

  private def clearNodeCount(): Unit = clearNodeCount(_ => {})

  private def clearNodeCount(continue: Int => AnyVal): Unit =  {
    nodeCount = 0
    continue(nodeCount)
  }
}
