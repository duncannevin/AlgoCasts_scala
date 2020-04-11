package linkedlist

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should._

class LinkedListSpec extends AnyFlatSpec with Matchers {

  "Insert First" should "append a node to the start of the list" in {
    val ll = new LinkedList[Int]
    ll.insertFirst(1)

    assert(ll.getFirst.data == 1)
  }

  "Insert First" should "insert a node to the start of a list with the head already defined" in {
    val ll = new LinkedList[Int]
    ll.insertFirst(1)
    ll.insertFirst(2)
    ll.insertFirst(3)

    assert(ll.getFirst.data == 3)
    assert(ll.getFirst.getNext.data == 2)
    assert(ll.getFirst.getNext.getNext.data == 1)
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

  "Get First" should "return the first element" in {
    val ll = new LinkedList[Int]
    ll.insertFirst(1)

    assert(ll.getFirst.data == 1)
  }

  "Get First" should "return the first element when multiple elements added" in {
    val ll = new LinkedList[Int]
    ll.insertFirst(1)
    ll.insertFirst(2)

    assert(ll.getFirst.data == 2)
  }

  "Get Last" should "return the last element when there is a single element" in {
    val ll = new LinkedList[Int]
    ll.insertFirst(1)

    assert(ll.getLast.data == 1)
  }

  "Get Last" should "return the last element when there are multiple elements" in {
    val ll = new LinkedList[Int]
    ll.insertFirst(1)
    ll.insertFirst(2)
    ll.insertFirst(3)
    ll.insertFirst(4)
    ll.insertFirst(5)

    assert(ll.getLast.data == 1)
  }

  "Clear" should "clear out the list" in {
    val ll = new LinkedList[Int]
    ll.insertFirst(1)
    ll.insertFirst(2)
    ll.insertFirst(3)
    ll.insertFirst(4)
    ll.insertFirst(5)
    ll.insertFirst(6)
    ll.insertFirst(7)

    assert(ll.size == 7)
    ll.clear()
    assert(ll.size == 0)
  }

  "Remove First" should "remove the first node when the list has a size of one" in {
    val ll = new LinkedList[String]
    ll.insertFirst("a")
    ll.removeFirst()

    assert(ll.size == 0)
    assert(ll.getFirst == null)
  }

  "Remove First" should "remove the first node when the list has a size of three" in {
    val ll = new LinkedList[Char]
    ll.insertFirst('c')
    ll.insertFirst('b')
    ll.insertFirst('a')
    ll.removeFirst()

    assert(ll.size == 2)
    assert(ll.getFirst.data == 'b')

    ll.removeFirst()

    assert(ll.getFirst.data == 'c')
    assert(ll.size == 1)
  }

  "Remove Last" should "remove the last node when the list is empty" in {
    val ll = new LinkedList[Char]

    noException should be thrownBy ll.removeLast()
  }

  "Remove Last" should "remove the last node when the list is length 1" in {
    val ll = new LinkedList[Char]
    ll.insertFirst('a')
    ll.removeLast()

    assert(ll.getFirst == null)
  }

  "Remove Last" should "remove the last node when the list is length 2" in {
    val ll = new LinkedList[Char]
    ll.insertFirst('a')
    ll.insertFirst('b')
    ll.removeLast()

    assert(ll.getFirst.data == 'b')
    assert(ll.getFirst.data == 'b')
    assert(ll.size == 1)
  }

  "Remove Last" should "remove the last node when the list is length 3" in {
    val ll = new LinkedList[Char]
    ll.insertFirst('a')
    ll.insertFirst('b')
    ll.insertFirst('c')
    ll.removeLast()
    ll.removeLast()

    assert(ll.getLast.data == 'c')
    assert(ll.size == 1)
  }
}
