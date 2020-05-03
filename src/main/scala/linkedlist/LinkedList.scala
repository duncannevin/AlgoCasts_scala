package linkedlist

import scala.annotation.tailrec

abstract class Node[T]()
case class EmptyNode[T]() extends Node[T]()
case class NonEmptyNode[T](data: T, next: Node[T]) extends Node[T]()

trait LinkedList[T] {
  def length: Int
  def insertFirst(data: T): LinkedList[T]
  def push(data: T): LinkedList[T]
  def reverse: LinkedList[T]
  def foreach(cb: T => Unit): Unit
  def last: Node[T]
  def first: Node[T]
  def tail: Node[T]
  def init: Node[T]
  def clear: EmptyLinkedList[T]

  def getAt(index: Int): Node[T]
}

class EmptyLinkedList[T] extends LinkedList[T] {
  def length: Int = 0
  def insertFirst(data: T): LinkedList[T] = new NonEmptyLinkedList[T](NonEmptyNode(data, EmptyNode()))
  def push(data: T): LinkedList[T] = insertFirst(data)
  def reverse: LinkedList[T] = this
  def foreach(cb: T => Unit): Unit = ()
  def last: EmptyNode[T] = EmptyNode()
  def first: EmptyNode[T] = EmptyNode()
  def tail: Node[T] = EmptyNode()
  def init: Node[T] = EmptyNode()
  def clear: EmptyLinkedList[T] = this
  def getAt(index: Int): Node[T] = EmptyNode()
}

class NonEmptyLinkedList[T](head: NonEmptyNode[T]) extends LinkedList[T] {
  def length: Int = length(head)
  @tailrec
  private def length(node: Node[T], count: Int = 0): Int = node match {
    case EmptyNode() => count
    case NonEmptyNode(_, next) => length(next, count + 1)
  }
  def insertFirst(data: T): LinkedList[T] = new NonEmptyLinkedList[T](NonEmptyNode(data, NonEmptyNode(head.data, head.next)))
  def push(data: T): LinkedList[T] = reverse.insertFirst(data).reverse
  def reverse: NonEmptyLinkedList[T] = {
    new NonEmptyLinkedList[T](reverse(head.next, NonEmptyNode(head.data, EmptyNode())))
  }
  @tailrec
  private def reverse(node: Node[T], newNode: NonEmptyNode[T]): NonEmptyNode[T] = node match {
    case EmptyNode() => newNode
    case NonEmptyNode(d, next) => reverse(next, NonEmptyNode(d, newNode))
  }
  def foreach(cb: T => Unit): Unit = foreach(cb, head)
  @tailrec
  private def foreach(cb: T => Unit, node: Node[T]): Unit = node match {
    case NonEmptyNode(data, EmptyNode()) => cb(data)
    case NonEmptyNode(data, next) =>
      cb(data)
      foreach(cb, next)
  }
  def last: Node[T] = NonEmptyNode(reverse.first.data, EmptyNode())
  def first: NonEmptyNode[T] = head
  def tail: Node[T] = head.next
  def init: Node[T] = {
    val selected = reverse.tail.asInstanceOf[NonEmptyNode[T]]
    reverse(selected.next, NonEmptyNode(selected.data, EmptyNode()))
  }
  def clear: EmptyLinkedList[T] = new EmptyLinkedList[T]
  def getAt(index: Int): Node[T] = getAt(index, head)
  @tailrec
  private def getAt(index: Int, node: Node[T]): Node[T] = (if (index < 0) 0 else index, node) match {
    case (0, n) => n
    case (_, EmptyNode()) => EmptyNode()
    case (ind, NonEmptyNode(_, next)) => getAt(ind - 1, next)
  }
}

object LinkedList {
  def apply[A](items: A*): LinkedList[A] = {

    makeInitial(items.toList, new EmptyLinkedList[A])
  }

  @tailrec
  def makeInitial[A](data: List[A], ll: LinkedList[A]): LinkedList[A] = data match {
    case Nil => ll
    case head::tail => makeInitial(tail, ll.push(head))
  }
}

object Scratch extends App {
  val foo: LinkedList[Int] = LinkedList(1, 2, 3)
  val foo2 = foo.insertFirst(111)
  val foo3 = foo2.push(999)
//  println(foo.length)
//  println(foo3.length)
//  println(foo3.last)
//  println(foo3.first)
//  println(foo3.reverse.first)
  println(foo3.first)
  println(foo3.tail)
  println(foo3.init)
  println(foo3.clear.insertFirst(333).first)
  println(foo3.getAt(-1))
}
