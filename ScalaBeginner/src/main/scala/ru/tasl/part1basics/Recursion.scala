package ru.tasl.part1basics

package exercises

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) n
    else n * factorial(n - 1)

  def factorial2(n: Int): Int =
    if (n <= 1) n
    else  {
      println(s"Computing factorial of $n - I first need factorial of ${n-1}")
      val result = n * factorial2(n - 1)
      println(s"Computed factorial of $n - I first need factorial of ${n-1}")
      result
  }

//  println(factorial2(10))
//  println(factorial2(5000))


//  simpleFunc("Tom", 10)
//  println(s"fact=${factorial(4)}")
//  println(s"fib=${fibonacci(8)}")
//  println(s"isPrime=${isPrime(8)}")
//  println(s"isPrime=${isPrime(243)}")
//  println(s"isPrime=${isPrime(2003)}")

  def simpleFunc(name: String, age: Int): Unit = {
    println(s"You are $name is $age years old")
  }

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else n + fibonacci(n - 1) + fibonacci(n - 2)

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = if (t<= 1) true else n % t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n / 2)
  }

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: => BigInt): BigInt =
      if (x<=1) accumulator
      else factHelper(x - 1, x * accumulator)
    factHelper(n, 1)
  }

  def fibonacciTailRec(n: Int): Int = {
    @tailrec
    def fiboTailRec(i: Int, last: Int, nexToLast: Int): Int = {
      if (i >= n) last
      else fiboTailRec(i + 1, last + nexToLast, last)
    }
    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }

  println(s"fibonacciTailRec=${fibonacciTailRec(5)}")


  def isPrimeTailRec(n: Int): Boolean = {
    @tailrec
    def isPrimeUntilTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntilTailRec(t - 1, n % t != 0 && isStillPrime)

    isPrimeUntilTailRec(n / 2, true)
  }


  val startTime: Long = System.nanoTime()
  println(anotherFactorial(5000))
  val endTime: Long = System.nanoTime()
  println(s"diff=${endTime-startTime}")

//  println(anotherFactorial(5000))

  @tailrec
  def stringConcat(str: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else stringConcat(str, n - 1, str + accumulator)
  }

  /**
   * переписать фибоначи и вычисление, является ли число простым на хвостовую рекурсию
   *
   */

}
