package ru.tasl.part2oop

import ru.tasl.playground.{Prince, TestForImport, Cinderella => Princess}

import java.sql
import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports {

  // package members are accessible by their simple name
  val writer = new Writer("wr")

  // import the package
  val princess = new Princess

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new Prince

  // 1. use FQ (Fully Qualified) names
  val date = new Date
//  val sqlDate = new SqlDate(2018, 1, 1)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???
}
