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

  //ex 7
  val fibs: Stream[Int] = {
    @tailrec
    def _fib(n:Int, acc1: Int, acc2: Int): Int = n match{
      case 0 => acc1
      case 1 => acc2
      case _ => _fib(n-1, acc2, acc1+acc2)
    }
    //generating infinite stream
    map(iterate(0)(_+1))(_fib(_,0, 1))
  }

  //not mine, but it's the better version => by @giacomocavalieri
  val fibs1: Stream[Int] = {
    def _fib(prev: Int, curr: Int): Stream[Int] = cons(prev, _fib(curr, prev+curr))
    _fib(0, 1)
  }

}
