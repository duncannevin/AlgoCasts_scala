package fib

import scala.collection._

object Fib {
  private val evaluated = mutable.Map.empty[Int, BigInt]

  def apply(n: Int): BigInt = {
    evaluated.getOrElse(n, {
      val evaled = evaluateFib(n)
      evaluated += (n -> evaled)
      evaled
    })
  }

  @scala.annotation.tailrec
  private def evaluateFib(n: Int, fibs: List[BigInt] = List(0, 1)): BigInt = n match {
    case 1 => fibs.last
    case _ => evaluateFib(n - 1, fibs :+ (fibs.last + fibs.init.last))
  }
}
