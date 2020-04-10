package chunk

object chunk {
  def apply[T](list: List[T], size: Int): List[List[T]] = doChunk[T](list, size)

  @scala.annotation.tailrec
  private def doChunk[T](list: List[T], size: Int, chunked: List[List[T]] = List.empty[List[T]]): List[List[T]] = list match {
    case l if l.isEmpty => chunked
    case l => doChunk(l.takeRight(l.length - size), size, chunked :+ l.take(size))
  }
}
