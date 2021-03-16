package lab

import org.junit.jupiter.api.Test
import u03.Lists.List._
import lab.ListsExtension.{filter, flatMap, map, _}
import u02.Optionals.Option._
import org.junit.jupiter.api.Assertions.assertEquals
import u02.Modules.Person
import u02.Modules.Person.{Student, Teacher, _}
import u03.Lists


class ListsExtensionTest {

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
    assertEquals(list, filter(list)(_ >=10))
  }

  @Test def testMax(){
    val list = Cons(10, Cons(20, Cons(30, Nil())))
    assertEquals(Some(30), max(list))
  }

  @Test def testCoursesByPeople() {
    val list : Lists.List[Person] = Cons(Student("Marco", 2020), Cons(Teacher("Bravetti", "LCMC"), Cons(Teacher("Ricci", "PCD"), Nil())))
    assertEquals(Cons("LCMC", Cons("PCD", Nil())), coursesByPeople(list))

    val list1: Lists.List[Person] = Cons(Student("Marco", 2020), Cons(Student("Bravetti", 2020), Nil()))
    assertEquals(Nil(), coursesByPeople(list1))
  }

  @Test def testFoldLeft(): Unit ={
    val list = Cons(1, Cons(2, Cons(3, Nil())))
    assertEquals(6, foldLeft(list)(0)(_+_))
    assertEquals(8, foldLeft(list)(2)(_+_))
  }

  @Test def testFoldRight(): Unit ={
    val list = Cons(1, Cons(2, Cons(3, Nil())))
    assertEquals(6, foldRight(list)(0)(_+_))
    assertEquals(8, foldRight(list)(2)(_+_))
  }

  @Test def testFoldLeftAndRight(): Unit ={
    val list = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))
    assertEquals(-16, foldLeft(list)(0)(_-_))
    assertEquals(-8, foldRight(list)(0)(_-_))
  }

}
