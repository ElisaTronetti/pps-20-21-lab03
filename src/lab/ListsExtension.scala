package lab

import u03.Lists._
import u03.Lists.List._
import u02.Optionals._
import u02.Optionals.Option._

import scala.annotation.tailrec

object ListsExtension {

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

  //ex 2
  //filter allows to check if there are elements bigger then h: if so, drop h and repeat, otherwise return h
  @tailrec
  def max(l: List[Int]): Option[Int] = l match {
    case Cons(h,t) => filter(t)(_>h) match {
      case Cons(_,_) =>max(drop(l,1))
      case _ => Some(h)
    }
    case Nil() => None()
  }
}
