package linkedlist

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class LinkedListSpec extends AnyFlatSpec with Matchers {
  "Insert First" should "append a node to the start of the list" in {
    val ll = new LinkedList[Int]
      .insertFirst(1)

    assert(ll.head.data == 1)
  }

  "Insert First" should "insert a node to the start of a list with the head already defined" in {
    val ll = new LinkedList[Int]
      .insertFirst(1)
      .insertFirst(2)
      .insertFirst(3)

    assert(ll.head.data == 3)
  }

  "Size" should "return 0 for no items" in {
    val ll = new LinkedList[Int]

    assert(ll.size == 0)
  }

  "Size" should "return 1 for a single item" in {
    val ll = new LinkedList[Int]
      .insertFirst(1)

    assert(ll.size == 1)
  }

  "Size" should "return the number of items in the linked list" in {
    val ll = new LinkedList[Int]
      .insertFirst(1)
      .insertFirst(1)
      .insertFirst(1)
      .insertFirst(1)
      .insertFirst(1)

    assert(ll.size == 5)
  }

  "Head" should "return the first element" in {
    val ll = new LinkedList[Int]
      .insertFirst(1)

    assert(ll.head.data == 1)
  }

  "Head" should "return the first element when multiple elements added" in {
    val ll = new LinkedList[Int]
      .insertFirst(1)
      .insertFirst(2)

    assert(ll.head.data == 2)
  }

  "Last" should "return the last element when there is a single element" in {
    val ll = new LinkedList[Int]
      .insertFirst(1)

    assert(ll.last.data == 1)
  }

  "Last" should "return the last element when there are multiple elements" in {
    val ll = new LinkedList[Int]
      .insertFirst(1)
      .insertFirst(2)
      .insertFirst(3)
      .insertFirst(4)
      .insertFirst(5)

    assert(ll.last.data == 1)
  }

  "Clear" should "clear out the list" in {
    val ll = new LinkedList[Int]
      .insertFirst(1)
      .insertFirst(2)
      .insertFirst(3)
      .insertFirst(4)
      .insertFirst(5)
      .insertFirst(6)
      .insertFirst(7)
      .clear

    assert(ll.size == 0)
  }

  "Tail" should "remove the first node when the list has a size of one" in {
    val ll = new LinkedList[String]
      .insertFirst("a")

    assert(ll.tail.head == null)
  }

  "Tail" should "remove the first node when the list has a size of three" in {
    val ll = new LinkedList[Char]
      .insertFirst('c')
      .insertFirst('b')
      .insertFirst('a')

    assert(ll.tail.head.data == 'b')
  }

  "Init" should "remove the last node when the list is empty" in {
    val ll = new LinkedList[Char]

    noException should be thrownBy ll.init
  }

  "Init" should "remove the last node when the list is length 1" in {
    val ll = new LinkedList[Char]
      .insertFirst('a')

    assert(ll.init.last == null)
  }

  "Init" should "remove the last node when the list is length 2" in {
    val ll = new LinkedList[Char]
      .insertFirst('a')
      .insertFirst('b')

    assert(ll.init.last.data == 'a')
  }

  "Init" should "remove the last node when the list is length 3" in {
    val ll = new LinkedList[Char]
      .insertFirst('a')
      .insertFirst('b')
      .insertFirst('c')

    assert(ll.init.last.data == 'b')
  }
//
//  "Insert Last" should "insert when list is empty" in {
//    val ll = new LinkedList[Char]
//    ll.insertLast('a')
//
//    assert(ll.getFirst.data == 'a')
//  }
//
//  "Insert Last" should "insert when list has a length of one" in {
//    val ll = new LinkedList[Char]
//    ll.insertLast('a')
//    ll.insertLast('b')
//
//    assert(ll.getLast.data == 'b')
//  }
//
//  "Insert Last" should "insert an element at the end of the list" in {
//    val ll = new LinkedList[Char]
//    ll.insertFirst('a')
//    ll.insertFirst('b')
//
//    assert(ll.size == 2)
//
//    ll.insertLast('2')
//
//    assert(ll.size == 3)
//    assert(ll.getLast.data == '2')
//  }
//
//  "Get At" should "return the node at a given index" in {
//    val ll = new LinkedList[Int]
//
//    assert(ll.getAt(0) == null)
//
//    ll.insertLast(1)
//    ll.insertLast(2)
//    ll.insertLast(3)
//    ll.insertLast(4)
//
//    assert(ll.getAt(0).data == 1)
//    assert(ll.getAt(1).data == 2)
//    assert(ll.getAt(2).data == 3)
//    assert(ll.getAt(3).data == 4)
//  }
}
