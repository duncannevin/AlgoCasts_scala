package chunk

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should._

class ChunkSpec extends AnyFlatSpec with Matchers {
  "chunk" should "divide a List of 10 elements with chunk size 2" in {
    val list: List[Int] = List.range(1, 11)
    val chunked = chunk(list, 2)
    val shouldBe = list.grouped(2).toList

    chunked should equal(shouldBe)
  }

  "chunk" should "divide a List of 3 elements with chunk size 1" in {
    val list: List[Int] = List.range(1, 4)
    val chunked = chunk(list, 1)
    val shouldBe = list.grouped(1).toList

    chunked should equal(shouldBe)
  }

  "chunk" should "divide a List of 5 elements with chunk size 3" in {
    val list: List[Int] = List.range(1, 6)
    val chunked = chunk(list, 3)
    val shouldBe = list.grouped(3).toList

    chunked should equal(shouldBe)
  }

  "chunk" should "divide a List of 13 elements with chunk size 5" in {
    val list: List[Int] = List.range(1, 14)
    val chunked = chunk(list, 5)
    val shouldBe = list.grouped(5).toList

    chunked should equal(shouldBe)
  }
}
