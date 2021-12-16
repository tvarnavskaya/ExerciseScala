package ru.tasl.part1basics

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)
  println(1 == x) // ==  !=  >=  <=
  println(!(1 == x)) // !  &&  ||

  var aVariable = 2
  aVariable += 3    // side affects
  println(aVariable)


  // instuctions (do) vs expressions (value)

  // if expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)

  // NEVER WRITE THIS AGAIN (imperative)
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  // Everything in scala is an Expression
  val aWeirdValue = (aVariable = 3)  // Unit === void
  println(aWeirdValue)
  val aBooleanValue = (aVariable == 3)
  println(aBooleanValue)

  // side affects: println(), whiles, reassigning
  /**This includes, but is not limited to:
   * mutating state,
   * reading input from the console,
   * printing output to the console,
   * reading, creating, deleting, or writing to files,
   * reading or writing from the network,
   * Reflection,
   * depending on the current time,
   * launching or aborting a thread or process, or
   * really any kind of I/O, and most importantly
   * calling an impure function.
   */

  // code blocks
  // expression
  val aCodeBlock: String = {
    val y = 2
    val z = y + 1

    if (z > 2) " hello" else "goodbye"
  }

  //val anotherValue = z + 1

  // 1. difference between "hello world" and println("hello world") ?
  // 2.
  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
}
