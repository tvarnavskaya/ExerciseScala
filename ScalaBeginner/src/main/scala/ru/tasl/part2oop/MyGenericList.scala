package ru.tasl.part2oop


abstract class MyGenericList[+A] {

  /**
   * head = first element of the list
   * tail = remainder of a list
   * isEmpty = is this list empty
   * add(int) => new list with this element added
   * toString => a string representation of the list
   */

  def head: A
  def tail: MyGenericList[A]
  def isEmpty: Boolean
  def add[B >: A](el: B): MyGenericList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](transformer: MyTransformer[A, B]): MyGenericList[B]
  def filter(predicate: MyPredicate[A]): MyGenericList[A]
  def flatMap[B](transformer: MyTransformer[A, MyGenericList[B]]): MyGenericList[B]

  def ++[B >: A](list: MyGenericList[B]): MyGenericList[B]
}

trait MyPredicate[-T] {
  def test(el: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(el: A): B
}

case object EmptyGeneric extends MyGenericList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyGenericList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](el: B): MyGenericList[B] = new ConsGeneric(el, EmptyGeneric)
  override def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): MyGenericList[B] = EmptyGeneric
  def filter(predicate: MyPredicate[Nothing]): MyGenericList[Nothing] = EmptyGeneric
  def flatMap[B](transformer: MyTransformer[Nothing, MyGenericList[B]]): MyGenericList[B] = EmptyGeneric

  def ++[B >: Nothing](list: MyGenericList[B]): MyGenericList[B] = list
}

case class ConsGeneric[+A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {
  override def head: A = h
  override def tail: MyGenericList[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](el: B): MyGenericList[B] = new ConsGeneric(el, this)
  override def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  override def filter(predicate: MyPredicate[A]): MyGenericList[A] = {
    if (predicate.test(head)) new ConsGeneric(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: MyTransformer[A, B]): MyGenericList[B] = {
    new ConsGeneric[B](transformer.transform(h), t.map(transformer))
  }

  override def ++[B >: A](list: MyGenericList[B]): MyGenericList[B] = {
    new ConsGeneric[B](h, t ++ list)
  }

  /*
  [1,2].flatMap(n => [n,n+1])
  = [1,2] ++ [2].flatMap(n => [n+1])
  = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n+1])
  = [1,2,2,3]

   */
  override def flatMap[B](transformer: MyTransformer[A, MyGenericList[B]]): MyGenericList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }

}

object Listtest extends App {
  val myListOfIntegers: MyGenericList[Int] = new ConsGeneric[Int](1, new ConsGeneric[Int](2, new ConsGeneric[Int](3, EmptyGeneric)))
  val cloneListOfIntegers: MyGenericList[Int] = new ConsGeneric[Int](1, new ConsGeneric[Int](2, new ConsGeneric[Int](3, EmptyGeneric)))
  val myListOfStrings: MyGenericList[String] = new ConsGeneric[String]("Hello", new ConsGeneric[String]("Scala", EmptyGeneric))
  println(myListOfIntegers)
  println(myListOfStrings)

  println(myListOfIntegers.filter(new MyPredicate[Int] {
    override def test(el: Int): Boolean = el % 2 == 0
  }))

  println(myListOfIntegers.map(new MyTransformer[Int, String] {
    override def transform(el: Int): String = s"this is $el"
  }))

  println(myListOfIntegers.flatMap(new MyTransformer[Int, MyGenericList[Int]] {
    override def transform(el: Int): MyGenericList[Int] = new ConsGeneric[Int](el, new ConsGeneric[Int](el + 1, EmptyGeneric))
  }))

  println(myListOfIntegers.flatMap(new MyTransformer[Int, MyGenericList[String]] {
    override def transform(el: Int): MyGenericList[String] = new ConsGeneric[String]("t", new ConsGeneric[String](s"this is $el", EmptyGeneric))
  }))

  println(cloneListOfIntegers == myListOfIntegers)
}