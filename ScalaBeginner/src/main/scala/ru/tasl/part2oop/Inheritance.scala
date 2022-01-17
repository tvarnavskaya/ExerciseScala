package ru.tasl.part2oop

class Inheritance extends App {

  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom") //private protected
  }

  class Cat extends Animal {
//    def crunch = {
//      eat
//      println("crunch crunch")
//    }
  }

//  val cat = new Cat
//  cat.eat

  //constructors
  class Person(name: String, age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  //overriding
  class Dog/*(override val creatureType: String)*/ extends Animal {
//    override val creatureType: String = "domestic"
    override def eat = {
//      super.eat
      println("crunch, crunch")
    }
  }
//  class Dog(dogType: String) extends Animal {
//    override val creatureType: String = dogType
//  }

//  val dog = new Dog
//  dog.eat

  //type substitution (broad: polymorphism)
//  val unknownAnimal: Animal = new Dog
//  unknownAnimal.eat

  // preventing overriding
  // 1 - use final on member
  // 2 - use final on class
  // 3 - yse sealed
}
