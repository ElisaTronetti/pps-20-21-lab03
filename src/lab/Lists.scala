package lab

import u03.Lists._
import u03.Lists.List._

import scala.annotation.tailrec

object Lists {

  //ex 1.a
  @tailrec
  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Cons(_,t) if (n>0) => drop(t,n-1)
    case _ => l
  }

  //ex 1.b
  def flatMap[A,B](l:List[A])(f: A => List[B]): List[B] = l match {
    case Cons(h,t) => append(f(h), flatMap(t)(f))
    case Nil() => Nil()
  }

  //ex 1.c
  def map[A,B](l: List[A])(mapper: A=>B): List[B] = flatMap(l)(x => Cons(mapper(x), Nil()))

  //ex 1.d
  def filter[A](l1: List[A])(pred: A=>Boolean): List[A] = flatMap(l1)( {
    case a if pred(a) => Cons(a, Nil())
    case _ => Nil()
  })
}
