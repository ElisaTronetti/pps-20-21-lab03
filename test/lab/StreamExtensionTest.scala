package lab

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u03.Lists.List.{Cons, Nil, _}
import u03.Streams.Stream.{toList, iterate, take, _}
import lab.StreamExtension.drop

class StreamExtensionTest {

  @Test def testDrop(): Unit ={
    val stream = take(iterate(0)(_+1))(4)
    assertEquals(Cons(2, Cons(3, Nil())), toList(drop(stream)(2)))
  }
}
