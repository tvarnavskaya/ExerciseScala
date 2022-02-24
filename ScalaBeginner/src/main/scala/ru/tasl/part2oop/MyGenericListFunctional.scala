package ru.tasl.part2oop

abstract class MyGenericListFunctional[+A] {

  /**
   * head = first element of the list
   * tail = remainder of a list
   * isEmpty = is this list empty
   * add(int) => new list with this element added
   * toString => a string representation of the list
   */

  def head: A
  def tail: MyGenericListFunctional[A]
  def isEmpty: Boolean
  def add[B >: A](el: B): MyGenericListFunctional[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  //higher order functions
  def map[B](transformer: A => B): MyGenericListFunctional[B]
  def filter(predicate: A => Boolean): MyGenericListFunctional[A]
  def flatMap[B](transformer: A => MyGenericListFunctional[B]): MyGenericListFunctional[B]

  def ++[B >: A](list: MyGenericListFunctional[B]): MyGenericListFunctional[B]
}


case object EmptyGenericFunctional extends MyGenericListFunctional[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyGenericListFunctional[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](el: B): MyGenericListFunctional[B] = new ConsGenericFunctional(el, EmptyGenericFunctional)
  override def printElements: String = ""

  def map[B](transformer: Nothing => B) : MyGenericListFunctional[B] = EmptyGenericFunctional
  def filter(predicate: Nothing => Boolean): MyGenericListFunctional[Nothing] = EmptyGenericFunctional
  def flatMap[B](transformer: Nothing => MyGenericListFunctional[B]): MyGenericListFunctional[B] = EmptyGenericFunctional

  def ++[B >: Nothing](list: MyGenericListFunctional[B]): MyGenericListFunctional[B] = list
}

case class ConsGenericFunctional[+A](h: A, t: MyGenericListFunctional[A]) extends MyGenericListFunctional[A] {
  override def head: A = h
  override def tail: MyGenericListFunctional[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](el: B): MyGenericListFunctional[B] = new ConsGenericFunctional(el, this)
  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  override def filter(predicate: A => Boolean): MyGenericListFunctional[A] = {
    if (predicate(head)) new ConsGenericFunctional(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: A => B): MyGenericListFunctional[B] = {
    new ConsGenericFunctional[B](transformer(h), t.map(transformer))
  }

  override def ++[B >: A](list: MyGenericListFunctional[B]): MyGenericListFunctional[B] = {
    new ConsGenericFunctional[B](h, t ++ list)
  }

  /*
  [1,2].flatMap(n => [n,n+1])
  = [1,2] ++ [2].flatMap(n => [n+1])
  = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n+1])
  = [1,2,2,3]

   */
  override def flatMap[B](transformer: A => MyGenericListFunctional[B]): MyGenericListFunctional[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

}

object ListtestFunctional extends App {
  val myListOfIntegers: MyGenericListFunctional[Int] = new ConsGenericFunctional[Int](1, new ConsGenericFunctional[Int](2, new ConsGenericFunctional[Int](3, EmptyGenericFunctional)))
  val cloneListOfIntegers: MyGenericListFunctional[Int] = new ConsGenericFunctional[Int](1, new ConsGenericFunctional[Int](2, new ConsGenericFunctional[Int](3, EmptyGenericFunctional)))
  val myListOfStrings: MyGenericListFunctional[String] = new ConsGenericFunctional[String]("Hello", new ConsGenericFunctional[String]("Scala", EmptyGenericFunctional))
  println(myListOfIntegers)
  println(myListOfStrings)

  println(myListOfIntegers.filter(new (Int => Boolean) {
    override def apply(el: Int): Boolean = el % 2 == 0
  }))

  println(myListOfIntegers.map(new (Int => String) {
    override def apply(el: Int): String = s"this is $el"
  }))

  println(myListOfIntegers.flatMap(new (Int => MyGenericListFunctional[Int]) {
    override def apply(el: Int): MyGenericListFunctional[Int] = new ConsGenericFunctional[Int](el, new ConsGenericFunctional[Int](el + 1, EmptyGenericFunctional))
  }))

  println(myListOfIntegers.flatMap(new (Int => MyGenericListFunctional[String]) {
    override def apply(el: Int): MyGenericListFunctional[String] = new ConsGenericFunctional[String]("t", new ConsGenericFunctional[String](s"this is $el", EmptyGenericFunctional))
  }))

  println(cloneListOfIntegers == myListOfIntegers)
}