package bst

import org.scalatest.flatspec.AnyFlatSpec

class BstSpec extends AnyFlatSpec {
  private val replacer = new Node(-1)

  "Bst.insert" should "insert correctly" in {
    val node = new Node(10)

    node.insert(5)
    node.insert(15)
    node.insert(17)

    assert {
      node.left.getOrElse(replacer).data == 5 &&
      node.right.getOrElse(replacer).data == 15 &&
      node.right.getOrElse(replacer).right.getOrElse(replacer).data == 17
    }
  }

  "Bst.contains" should "return node with the same data" in {
    val node = new Node(10)

    node.insert(5)
    node.insert(15)
    node.insert(20)
    node.insert(0)
    node.insert(-5)
    node.insert(3)

    val three = node.left.getOrElse(replacer).left.getOrElse(replacer).right.getOrElse(replacer).data

    assert(node.contains(3).getOrElse(replacer).data == three)
  }

  "Bst.contains" should "return None if value is not found" in {
    val node = new Node(10)
    node.insert(5)
    node.insert(15)
    node.insert(20)
    node.insert(0)
    node.insert(-5)
    node.insert(3)

    assert(node.contains(9999).isEmpty)
  }
}
