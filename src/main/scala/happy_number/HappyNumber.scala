package happy_number

import scala.annotation.tailrec

object HappyNumber {
  /*
    Write an algorithm to determine if a number n is "happy".

      A happy number is a number defined by the following process: Starting with any positive integer, replace the number by
    the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it
    loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

    Return True if n is a happy number, and False if not.
  * */

  @tailrec
  def isHappy(n: Int, iterations: Int = 0): Boolean = (compute(n), iterations) match {
    case (1, _) => true
    case (_, 10000) => false
    case (int, iter) => isHappy(int, iter + 1)
  }

  private def compute(n: Int): Int = n.toString.toList.map(_.toString.toDouble).map(Math.pow(_, 2)).sum.toInt
}

object HappyBox extends App {
  List(111111).foreach{ int =>
    println(s"$int: ${HappyNumber.isHappy(int)}")
  }
}
