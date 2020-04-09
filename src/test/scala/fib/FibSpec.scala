package fibspec

import fib.Fib
import org.scalatest.flatspec.AnyFlatSpec

class FibSpec extends AnyFlatSpec {
  "Fib" should "calculate the correct fib value for index 1" in {
    assert(Fib(1) == 1)
  }

  "Fib" should "calculate the correct fib value for index 2" in {
    assert(Fib(2) == 1)
  }

  "Fib" should "calculate the correct fib value for index 3" in {
    assert(Fib(3) == 2)
  }

  "Fib" should "calculate the correct fib value for index 4" in {
    assert(Fib(4) == 3)
  }

  "Fib" should "calculate the correct fib value for index 39" in {
    assert(Fib(39) == 63245986)
  }

  "Fib" should "calculate the correct fib value for index 50" in {
    assert(Fib(50) == 12586269025L)
  }

  "Fib" should "calculate the correct fib value for index 60" in {
    assert(Fib(60) == 1548008755920L)
  }

  "Fib" should "calculate the correct fib value for index 70" in {
    assert(Fib(70) == 190392490709135L)
  }
}
