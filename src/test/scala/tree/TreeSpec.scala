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

  "Tree" should "get level widths" in {
    val t = new Tree[Int]
    t.setRoot(0)
    val root = t.getRoot

    root.add(1)
    root.add(2)
    root.add(3)
    root.getChildren.head.add(4)
    root.getChildren(2).add(5)

    t.levelWidth should equal (List(1, 3, 2))
  }

  "Tree" should "get level widths of nodes at widest point" in {
    val t = new Tree[Int]
    t.setRoot(0)
    val root = t.getRoot

    root.add(1)
    root.getChildren.head.add(2)
    root.getChildren.head.add(3)
    root.getChildren.head.getChildren.head.add(4)

    t.levelWidth should equal (List(1, 1, 2, 1))
  }
}
