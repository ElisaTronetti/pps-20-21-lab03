package lab

import org.junit.jupiter.api.Test
import u03.Lists.List._
import lab.Lists.{filter, map, _}
import org.junit.jupiter.api.Assertions.assertEquals

class ListsTest {

  @Test def testDrop(){
    val list = Cons(10, Cons(20, Cons(30, Nil())))
    assertEquals(Cons(20, Cons(30, Nil())), drop(list, 1))
    assertEquals(Cons(30, Nil()), drop(list, 2))
    assertEquals(Nil(), drop(list, 5))
    assertEquals(list, drop(list, 0))
  }

  @Test def testFlatMap(){
    val list = Cons(10, Cons(20, Cons(30, Nil())))
    assertEquals(Cons(11,Cons(21, Cons(31, Nil()))), flatMap(list)(v => Cons(v+1, Nil())))
    assertEquals(Cons(11,Cons(12, Cons(21, Cons(22, Cons(31, Cons(32, Nil())))))), flatMap(list)(v => Cons(v+1, Cons(v+2, Nil()))))
  }

  @Test def testMap(){
    val list = Cons(10, Cons(20, Cons(30, Nil())))
    assertEquals(Cons(11,Cons(21, Cons(31, Nil()))), map(list)(_+1))
  }

  @Test def testFilter(){
    val list = Cons(10, Cons(20, Cons(30, Nil())))
    assertEquals(Cons(20, Cons(30, Nil())), filter(list)(_ >=20))
  }
}
