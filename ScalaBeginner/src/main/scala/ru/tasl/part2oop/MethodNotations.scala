package ru.tasl.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(str: String): Person = new Person(s"$name ($str)", favoriteMovie)
    def unary_! : String = s"$name do smth"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
  }

  val mary = new Person("Mary", "Inception")
  val mary2 = mary + "the RockStar"
  println(mary2.name)
  println(mary.likes("Inception"))
  println(mary likes "Inception")
  // infix notation (syntactic sugar)

  // "operators"
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))
  println(5.<=(5))

  //prefix notation
  val x = -1 // = 1.unary_-
  val y = 1.unary_-   // + - ~ !

  println(!mary)
  println(mary.unary_!)

  val b = true
  println(!b)
  println(b.unary_!)

  // postfix
  println(mary.isAlive)
  println(mary isAlive)


  // apply
  println(mary.apply())
  println(mary())


  /**
   * 1. Overload + operator
   *    Mary + "the rockstar" => new Person ("Mary (the rockstar)", favoriteMovie)
   *
   * 2. Add an age to the Person class
   *    Add a unary + operator => new Person with the age  + 1
   *    +mary => mary with the age incrementer
   *
   * 3. Add a "learns" method in the Person class (subject: String) => "Mary learns Scala"
   *    Add a learnScala method, calls learns method with "Scala"
   *    Use it in postfix notation
   *
   * 4. Overload the apply method
   *    mary.apply(2) => "Mary watched Inception 2 times"
   */
}



class Cat(val name: String) extends Animal {

}

class Dog(val name: String) extends Animal {

}

trait Animal

class AnimalSchool {
  def teach(obj: Cat) = {

  }

  def teach(obj: Dog) = {

  }

  def teach(obj: Animal) = {

  }
}