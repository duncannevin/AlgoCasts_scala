package tree

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TreeSpec extends AnyFlatSpec with Matchers {
  "Tree" should "start empty" in {
    val t = new Tree[Any]
    assert(t.getRoot == null)
  }

  "Tree" should "traverse breadth first" in {
    val t = new Tree[Int]
    var numbers = List.empty[Int]

    t.setRoot(1)
    t.getRoot.add(2)
    t.getRoot.add(3)
    t.getRoot.getChildren.head.add(4)

    t.traverseBF(num => numbers = numbers :+ num)

    numbers should equal (List(1, 2, 3, 4))
  }

  "Tree" should "traverse depth first" in {
    var numbers = List.empty[Int]
    val t = new Tree[Int]

    t.setRoot(1)
    t.getRoot.add(2)
    t.getRoot.add(4)
    t.getRoot.getChildren.head.add(3)

    t.traverseDF(num => numbers = numbers :+ num)

    numbers should equal (List(1, 2, 3, 4))
  }
}
