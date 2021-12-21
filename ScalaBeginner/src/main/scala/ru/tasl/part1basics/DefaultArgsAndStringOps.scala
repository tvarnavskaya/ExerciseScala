package ru.tasl.part1basics

import java.nio.charset.Charset

object DefaultArgsAndStringOps extends App {

  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1, n* acc)

  println(trFact(2))
  println(trFact(2,2))

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  savePicture("jpg", 800, 600)
  savePicture(height = 800)
  savePicture("png")
  savePicture(width = 480, height = 100)
  savePicture("png", 480)





  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  val aWrongNumberString = "590"
  aWrongNumberString.toInt

  println('a' +: aNumberString :+ 'z')

  val list = List(1,2,3)
  val list2 = 5 +: list // 5,1,2,3
  val list3 = list2 :+ 6 // 5,1,2,3,6
  val list4 = list :: list2 // 1,2,3,5,1,2,3

  // F - interpolators
  val name = "Tom"
  val speed = 1.2f
  val myth = f"do smth $name%s by $speed%2.2f"


  println(name.reverse)
  name.substring(1,2)


  name.getBytes
  name.getBytes("UTF-8")
  name.getBytes(Charset.defaultCharset())
  println(myth)

  /**
   * Посмотреть методы строк (не обязательно запоминать, но надо знать, что есть)
   * Примеры: создание подстроки, разбиение по символу, замена символов...
   */
}
