package ru.tasl.part2oop

object ExecutorObj extends App {

//  println(PocketCalculator.add(100, Int.MaxValue))
//  println(PocketCalculator.subtract(100, Int.MaxValue))
//  println(PocketCalculator.multiply(100, Int.MaxValue))
//
//  println(PocketCalculator.add(Int.MaxValue, 10))
//  println(PocketCalculator.divide(2, 0))
}

object PocketCalculator {
  def add(x: Int, y: Int): Int = {
    val res = x + y
    if (x > 0 && y > 0 && res < 0) throw new OverflowException
    if (x < 0 && y < 0 && res > 0) throw new UnderflowException
    else res
  }
  def subtract(x: Int, y: Int) = {
    val res = x - y
    if (x > 0 && y < 0 && res < 0) throw new OverflowException
    if (x < 0 && y > 0 && res > 0) throw new UnderflowException
    else res
  }
  def multiply(x: Int, y: Int) = {
    val res = x * y
    if (x > 0 && y > 0 && res < 0) throw new OverflowException
    if (x < 0 && y < 0 && res < 0) throw new OverflowException
    if (x > 0 && y < 0 && res > 0) throw new UnderflowException
    if (x < 0 && y > 0 && res > 0) throw new UnderflowException
    else res
  }
  def divide(x: Int, y: Int) = {
    if (y == 0) throw new MathCalculationException
    else x / y
  }
}
class OverflowException extends RuntimeException
class UnderflowException extends RuntimeException
class MathCalculationException extends RuntimeException("Division by 0")