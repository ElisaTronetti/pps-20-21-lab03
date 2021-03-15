package lab

import u03.Streams.Stream
import u03.Streams.Stream._

import scala.annotation.tailrec

object StreamExtension {

  //ex 5
  //if n>0 I have to modify the stream: remove the head and then recursion starting by tail
  @tailrec
  def drop[A](stream: Stream[A])(n: Int): Stream[A] = stream match {
    case Cons(_,t) if n>0 => drop(t())(n-1)
    case _ => stream
  }

  //ex 6
  def constant[A](c: A): Stream[A] = iterate(c)(_ => c)

}
