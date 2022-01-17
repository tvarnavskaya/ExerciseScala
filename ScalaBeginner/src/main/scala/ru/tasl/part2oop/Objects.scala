package ru.tasl.part2oop

object Objects extends App {

    object Person { // type + its only instance
      // "static"/"class" - level functionality
      val N_EYES = 2

      def canFly: Boolean = false

      // factory method
      def apply(mother: Person, father: Person): Person = new Person("Bobbie", "brown")

      def apply(parent: Person, name: String): Person = new Person(name, parent.eyesColor)
    }
    // COMPANIONS
    class Person(val name: String, val eyesColor: String) {
      // instance-level functionality

    }

    println(Person.N_EYES)
    println(Person.canFly)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

    // Scala object = SINGLETON INSTANCE

    val mary = new Person("Mary", "green")
    val john = new Person("John", "blue")
    println(mary == john)


    val bobbie = Person(mary, john)
    val sam = Person(john, "Sam")

    println(s"name=${sam.name}, eyeColor=${sam.eyesColor}")

  // Scala Applications = Scala Object with def main(args: Array[String]): Unit
}
