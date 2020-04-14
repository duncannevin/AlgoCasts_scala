package tree

class Tree[T] {
  private var root: Node[T] = _

  def setRoot(data: T): Unit = root = new Node[T](data)

  def getRoot: Node[T] = root

  def traverseBF(cb: T => AnyVal): Unit = traverse(isBF = true, cb, List(root))

  def traverseDF(cb: T => AnyVal): Unit = traverse(isBF = false, cb, List(root))

  @scala.annotation.tailrec
  private def traverse(isBF: Boolean, cb: T => AnyVal, slate: List[Node[T]]): Unit = slate match {
    case Nil =>
    case head :: tail =>
      val newSlate = {
        if (isBF) tail ::: head.getChildren
        else head.getChildren ::: tail
      }
      cb(head.data)
      traverse(isBF, cb, newSlate)
  }
}
