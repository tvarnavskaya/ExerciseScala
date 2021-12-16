package ru.tasl.part1basics

object ValuesVariablesTypes extends App {

  // values
  val x1: Int = 42
  val x2 = 42
  //val x3: Int = "test"
  println(x1)
  println(x2)

  // VALS ARE IMMUTABLE
  //x1 = 2

  val aString: String = "hello"
  val anotherString: String = "goodbye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x1
  val aShort: Short = 4674
  val aLong: Long = 4429382357982375923L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14


  // variables
  var aVariable: Int = 4
  aVariable = 5 // side affect

  def test(): String = {
    val x = "test"
    val x2 = x + "test2"
    x2
  }
}

