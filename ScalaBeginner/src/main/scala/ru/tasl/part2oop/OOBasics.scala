package ru.tasl.part2oop

object OOBasics extends App {

  val test: Option[String] = None
  val dt = test match {
    case Some("task") => 1
    case Some("workflow") => 2
    case _ => throw new RuntimeException("not valid value")
  }
  System.exit(0)
  val person = new Person("John", 26)
  println(person)
  println(person.age)
  println(person.x)
  person.greet("Tom")
  person.greet

  val person2 = new Person("Jack")

  val person3 = new Person

}

// class parameters are NOT FIELDS
class Person(name: String, val age: Int = 0) { // constructor

  // body
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
//  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

  /*
  Реализовать 2 класса: Novel, Writer

  Writer: firstName, lastName, year
    - method fullName (соединение имени и фамилии)

  Novel: name, year of release, author - (Writer)
    - authorAge
    - isWritten(author): Boolean    пример:
    val writer = new Writer("Иван","Иванов",1900)
    val novel2 = new Novel("какая-то книга", 1920, writer)
    novel2.isWritten(new Writer("Иван","Иванов",1900)) - false
    novel2.isWritten(writer) - true
    - copy (new year of release) = new instance of Novel
    val novel2 = new Novel("какая-то книга", 1920, writer)
    novel2.copy(1922) => new Novel

   */

  /*
  Counter class
    - receives an int value  // constructor
    - method current count
    - method to incr/decr => new Counter
    val cnt = new Counter(10)
    cnt.incr => new Counter   // 11
    cnt.incr                  // 11

    val cnt2 = cnt.incr => new Counter   // 11
    cnt2.incr                            // 12

    - overload incr/decr to receive an amount
    val cnt = new Counter(10)
    cnt.incr(3) => new Counter   // 13
    cnt.incr(5)                  // 15

    val cnt2 = cnt.incr(3) => new Counter   // 13
    cnt2.incr(5)                            // 18
   */
