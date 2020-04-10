package bst

class Node(val data: Int) {
  var left: Option[Node] = None
  var right: Option[Node] = None

  def insert(value: Int): Unit = insert(value, this)

  @scala.annotation.tailrec
  private def insert(data: Int, bst: Node): Unit = bst match {
    case node if node.data >= data && node.left.isEmpty => bst.left = Some(new Node(data))
    case node if node.data < data && node.right.isEmpty => bst.right = Some(new Node(data))
    case node if node.left.nonEmpty && node.data >= data => insert(data, node.left.head)
    case node if node.right.nonEmpty => insert(data, node.right.head)
  }

  def contains(data: Int): Option[Node] = contains(data, this)

  @scala.annotation.tailrec
  private def contains(data: Int, bst: Node): Option[Node] = bst match {
    case node if node.data == data => Some(node)
    case node if node.left.nonEmpty && node.data >= data => contains(data, node.left.head)
    case node if node.right.nonEmpty && node.data < data => contains(data, node.right.head)
    case _ => None
  }

  private def findBottom(data: Int, bst: Node = this): Node = bst match {
    case node if node.left.isEmpty || node.right.isEmpty => node
    case node if node.left.nonEmpty && node.data >= data => findBottom(data, node.left.head)
    case node if node.right.nonEmpty && node.data < data => findBottom(data, node.right.head)
  }
}
