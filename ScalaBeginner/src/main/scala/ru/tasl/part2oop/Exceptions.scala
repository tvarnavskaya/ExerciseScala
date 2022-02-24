package ru.tasl.part2oop

object Exceptions extends App {

  val x: String = null
//  println(x.length) // NullPointerException

  // 1. throwing exceptions
//  val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exceptions and Errors are the major Throwable subtypes (smth wrong with a program/ smth wrong with a system)

  // 2. catching exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    getInt(true)
  } catch {
//    case e: RuntimeException => println("caught a Runtime exception")
//    case e: NullPointerException => println("caught a Runtime exception")
      case e: RuntimeException => 43
  } finally {
    println("finally")
  }

  println(s"potentialFail=$potentialFail")

//  class MyException extends Exception
//  val exception = new MyException

//  throw exception

  /*
  1. Crash a program with an OOM
  2. Crash a program with a SOError
  3. PocketCalculator
    - add(x,y)
    -subtract(x,y)
    -multiply(x,y)
    -divide(x,y)

    throw:
      - OverflowException if add(x,y) exceeds Int.MAX_VALUE
      - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
      - MathCalculationException for division by zero

   */

  // OOM
//  val array = Array.ofDim(Int.MaxValue)

  // SOE
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite
}
