package tree

class Tree[T] {
  private var root: Node[T] = _

  def setRoot(data: T): Unit = root = new Node[T](data)

  def getRoot: Node[T] = root

  def traverseBF(cb: T => AnyVal): Unit = traverse(isBF = true, cb, List(root))

  def traverseDF(cb: T => AnyVal): Unit = traverse(isBF = false, cb, List(root))

  def levelWidth: List[Int] = levelWidth(List(root, null), List(0))

  @scala.annotation.tailrec
  private def levelWidth(slate: List[Node[T]], widths: List[Int]): List[Int] = slate match {
    case head::Nil if head == null => widths
    case head::tail => head match {
      case null => levelWidth(tail :+ null, widths :+ 0)
      case _ => levelWidth(tail ::: head.getChildren, widths.init :+ widths.last + 1)
    }
  }

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
