package ru.tasl.part2oop

abstract class MyList {

  /*

  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  toString => a string representation of the list

   */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  protected def printElements: String
  override def toString: String = s"[$printElements]"
}

//object Empty extends MyList {
//
//}
//
//class Cons(h: Int, t: Int) extends MyList {
//
//}
