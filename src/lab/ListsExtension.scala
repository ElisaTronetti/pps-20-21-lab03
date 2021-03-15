package lab

import u02.Modules.Person
import u02.Modules.Person.Teacher
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

  //ex 3
  //flatmap of l, the function in case of teacher takes the course, return an empty list otherwise
  def coursesByPeople(l: List[Person]): List[String] = flatMap(l)({
    case Teacher(_,c) => Cons(c, Nil())
    case _ => Nil()
  })

  //ex 4
  //apply f to init and the head and then
  //recursive iteration starting by the tail until the end of the list (return init at the end)
  @tailrec
  def foldLeft[A,B](l: List[A])(init: B)(f: (B,A) => B): B = l match {
    case Cons(h,t) => foldLeft(t)(f(init,h))(f)
    case _ => init
  }

  //recursion to apply the function f in the correct order, by actually valuating first the tail, the adding to the current
  //head and so on until the end of the list (foldLeft is much more efficient, but reversing the list and then applying foldLeft
  //I think it would be even worst)
  def foldRight[A,B](l: List[A])(init: B)(f: (A,B) => B): B = l match {
    case Cons(h,t) => f(h, foldRight(t)(init)(f))
    case _ => init
  }

}
