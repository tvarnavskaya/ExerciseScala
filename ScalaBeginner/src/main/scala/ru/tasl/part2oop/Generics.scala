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

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? hard question => turns a list of Cat to a list of Animals

  // 2. NO = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, no! CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded types
  class Cage[A <: Animal](animal: A)
//  val cage = new Cage(new Dog)

  class Car
//  val newCage =new Cage(new Car)


  class MyList2[+A] {
    def add[B >: A](element: B): MyList2[B] = ???

    /*
    A = Cat
    B = Animal

     */

    //expand MyList to be generic
  }




  class MyList3[+A] {
    def add[B >: A](element: B): MyList3[B] = ???

    /*
    A = Cat
    B = Animal

     */

    //expand MyList to be generic
  }
}