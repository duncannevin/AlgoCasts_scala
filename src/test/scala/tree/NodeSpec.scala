package tree

import org.scalatest.flatspec.AnyFlatSpec

class NodeSpec extends AnyFlatSpec {
  "Node" should "have data property" in {
    val node = new Node[Char]('a')
    assert(node.data == 'a')
  }

  "Node" should "have children property" in {
    val node = new Node[Char]('a')
    assert(node.getChildren.isEmpty)
  }

  "Node" should "add children" in {
    val node = new Node[Char]('a')
    node.add('b')
    assert(node.getChildren.head == 'b')
  }

  "Node" should "remove children" in {
    val node = new Node[Char]('a')
    node.add('b')
    assert(node.getChildren.length == 1)
    node.remove('b')
    assert(node.getChildren.isEmpty)
  }
}
