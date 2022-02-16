package ru.tasl.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  //printlninstance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 30)  // apply method - make an object be called like a function

  // 6. CCs are serializable
  // Akka - messages CCs

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  expand MyList - use CCs and COs

   */
}
