package linkedlist

import org.scalatest.flatspec.AnyFlatSpec

class LinkedListSpec extends AnyFlatSpec {

  "Insert First" should "append a node to the start of the list" in {
    val ll = new LinkedList[Int]
    ll.insertFirst(1)

    assert(ll.getHead.data == 1)
  }

  "Insert First" should "insert a node to the start of a list with the head already defined" in {
    val ll = new LinkedList[Int]
    ll.insertFirst(1)
    ll.insertFirst(2)
    ll.insertFirst(3)

    assert(ll.getHead.data == 3)
    assert(ll.getHead.getNext.data == 2)
    assert(ll.getHead.getNext.getNext.data == 1)
  }

  "Size" should "return 0 for no items" in {
      val ll = new LinkedList[Int]

      assert(ll.size == 0)
  }

  "Size" should "return 1 for a single item" in {
    val ll = new LinkedList[Int]
    ll.insertFirst(1)

    assert(ll.size == 1)
  }

  "Size" should "return the number of items in the linked list" in {
    val ll = new LinkedList[Int]
    ll.insertFirst(1)
    ll.insertFirst(1)
    ll.insertFirst(1)
    ll.insertFirst(1)
    ll.insertFirst(1)

    assert(ll.size == 5)
  }
}
