package lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil, _}
import u03.Streams.Stream.{iterate, take, toList, _}
import lab.StreamExtension.{constant, drop, fibs, fibs1}

class StreamExtensionTest {

  @Test def testDrop() {
    val stream = take(iterate(0)(_+1))(4)
    assertEquals(Cons(2, Cons(3, Nil())), toList(drop(stream)(2)))
  }

  @Test def testIterate(): Unit ={
    val res = toList(take(constant("x"))(3))
    assertEquals(Cons("x", Cons("x", Cons("x", Nil()))), res)
  }

  @Test def testFibs(): Unit ={
    val res = toList(take(fibs)(5))
    assertEquals(Cons(0, Cons(1, Cons(1, Cons(2, Cons(3, Nil()))))), res)
  }

  @Test def testFibs1(): Unit ={
    val res = toList(take(fibs1)(5))
    assertEquals(Cons(0, Cons(1, Cons(1, Cons(2, Cons(3, Nil()))))), res)
  }
}
