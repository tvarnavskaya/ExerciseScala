package ru.tasl.part1basics

object Functions extends App {
  def aFunction1(a: String, b: Int): String = "test"
  def aFunctions(a: String, b: Int) = {
    a + " " + b
    s"$a $b"
  }

  println(aFunctions("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  /**
   * for (int i= 0; i < 5; i += 2) {
   *
   * }
   */
  def aRepeatedFunction(aString: String,  n: Int): String = {
    if (n == 1) aString
    else s"$aString ${aRepeatedFunction(aString, n - 1)}"
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)  //function with side effect

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }


  /**
   * 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
   *
   * 1.5 aRepeatedFunction - попробовать реализовать любой простой цикл в виде рекурсии
   *
   * 2. Factorial function 1 * 2 * 3 * ... * n    factorial(5) = 120
   *
   * 3. A Fibonacci function        fib(4) =
   *    f(0) = 0
   *    f(1) = 1
   *    f(2) = f(n - 1) + f(n - 2)
   *
   * 4. Test if a number is prime
   */
}
