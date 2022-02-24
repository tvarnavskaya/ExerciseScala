package ru.tasl.part3fp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(el: Int): Int = el * 2
  }

  println(doubler(2))

  // function types = Function[A,B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 5)

  // ((Int, Int) => Int) - syntactic sugar for Funciton2
  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // Function types Function2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
  1. a function which takes 2 strings and concatenates them
  2. transform the MyPredicate and MyTransformer into function types
  3. define a function which takes an int and returns another function with takes an int and returns an int
    - what's the type of this function
    - how to do it

   */

  // new Function2[String, String, String]
  val concatStr = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  println(concatStr("test","scala"))


  val funWithFunction = new Function1[Int, Function[Int, Int]] {
    override def apply(x: Int): Function[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  println(funWithFunction(2))

  val superAdder = new ((Int) => Function[Int, Int]) {
    override def apply(x: Int): Function[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }



  println(superAdder(3)(4))
  val adder3 = superAdder(3)
  println(adder3(4))
}

class Action {
  def execute(el: Int): String = ???
}


trait MyFunction[A, B] {
  def apply(el: A): B
}