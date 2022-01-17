package ru.tasl.part2oop

object Generics extends App {

  class MyList[A] {
    // use the type A

  }

  class MyMap[Key, Value]

  val listOfInt = new MyList[Int]
  val listOfString = new MyList[String]


  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfInt = MyList.empty[Int]

  // variance problems
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
}