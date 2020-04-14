package tree

class Node[T](val data: T) {
  private var children: List[Node[T]] = List.empty[Node[T]]

  def add(data: T): Unit = children = children :+ new Node[T](data)

  def remove(data: T): Unit = children = children.filter(_ != data)

  def getChildren: List[Node[T]] = children
}
