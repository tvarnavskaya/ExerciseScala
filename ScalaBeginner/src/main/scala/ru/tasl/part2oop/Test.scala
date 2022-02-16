package ru.tasl.part2oop

object Test extends App {

  case class C(
                targetPartitionExpression: String,
                targetTable_rowSize: Int,
                test: Array[Int]
              )

  val arr = Array(1,2,3)
  val str = if (arr.isInstanceOf[Array[_ <: Any]]) arr.mkString(",") else arr.toString
  println(s"str=${getParamValue(arr)}")

  System.exit(0)

  val c = C("expr", 5, Array(1,2,3))

  def getParamValue (param: Any): String = {
    var result: String = ""
    if (param.isInstanceOf[Array[_ <: Any]]) {
      result = param.asInstanceOf[Array[_ <: Any]].mkString(",") //param.asInstanceOf[Iterator[Any]].map(_.toString).reduce((el1, el2) => s"$el1,$el2")
      if (param.isInstanceOf[Seq[Any]]) {
        result = param.asInstanceOf[Seq[_]].map(_.toString).reduce((el1, el2) => s"$el1,$el2")
      } else
        result = param.toString
    }
    result
  }


    def getCCParams2(cc: Product) = cc.getClass.getDeclaredFields.map( _.getName ).zip( cc.productIterator.to ).toMap

  println("22:"+getCCParams2(c))


  def getCCParams(cc: AnyRef) =
    cc.getClass.getDeclaredFields.foldLeft(Map.empty[String, String]) { (a, f) =>
      f.setAccessible(true)
      val el = f.get(cc)
      a + (f.getName -> (if (el.isInstanceOf[Traversable[Any]]) el.asInstanceOf[Traversable[Any]].mkString(",") else el.toString))
    }

  //"targetPartitionExpression" -> "expr", "targetTable_rowSize" -> "5", "test" -> "1,2,3"

  println("1:"+c)
  println("2:"+getCCParams(c))
}
