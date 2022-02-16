package ru.tasl.part2oop
import org.json4s.{Extraction, _}
import org.apache.commons.lang.StringUtils

object Test2 extends App {



  case class C(
                targetPartitionExpression: String,
                targetTable_rowSize: Int,
                test: Array[Int],
                test2: Seq[Int],
                test3: List[Int]
              )

  //setup
  val cla = C("expr", 5, Array(1,2,3), Seq(1,2,3), List(1,2,3))

  val someMap = Map("key1" -> "value1", "key2" -> "List(value2)")
  val classToMap = Extraction.decompose(cla)(DefaultFormats).values.asInstanceOf[Map[String,String]]

  //f
  def trimList(value: Any): Any = {
    val tt = if (value.isInstanceOf[Array[_ <: Any]]) value.asInstanceOf[Array[Any]].mkString(",")

    val res =  StringUtils.substringBetween (value.toString, "List(", ")")
    if (res == null) value else res
  }

  //results
  val resultMapValues = someMap.mapValues(trimList) //работает
  val cleanMap = classToMap.mapValues(trimList) //не работает

  println(s"classToMap=$classToMap")
//  println(s"trimList=$trimList")
  println(s"resultMapValues=$resultMapValues")
//  println(s"cleanMap=$cleanMap")


  val ddlTableScript = "create table if not exists DL_INTERFACE.csr_ip_gosreg (`dtreg`      date      comment'Дата регистрации'\n     ,`dtzap`      timestamp      comment'Дата фактического внесения записи в реестр'\n     ,`idkorr`      decimal(38)      comment'Идентификатор события о корректировке/отмене данной записи'\n     ,`idreg`      decimal(38)      comment'Идентификатор события о регистрации'\n     ,`idregorg`      decimal(38)      comment'Код по СПРО регистрирующего органа, присвоившего ОГРН'\n     ,`idsostzap`      decimal(38)      comment'Признак отмены записи по суду/решению РО)'\n     ,`idvidreg`      decimal(38)      comment'Код вида записи(регистрации)'\n     ,`idzap`      decimal(38)      comment'Идентификатор первичного события о регистраци'\n     ,`ip_id`      decimal(38)      comment'Уникальный идентификатор индивидуального предпринимателя'\n     ,`regnum`      string      comment'Регистрационный номер Записи(ГРНИП/ОГРНИП)'\n     ,`_tech_exec_job_id`      string      comment'Id запуска (RLS_ID)'\n     ,`_tech_load_dt`      timestamp      comment'Дата загрузки')stored as orc"
  val databaseSchema = "dl_tmp"
  val sourceEntity_name = "csr_ip_gosreg_test2"
  def ddlTableScriptWithReplacedSchemaAndTableNames = {
    val pattern = "(create table).*\\s+(\\w+)\\.+(\\w+)(\\s*\\().*".r
    val changedDdlTableScript = for {
      patternMatch <- pattern.findAllMatchIn(ddlTableScript)
      schemaName = patternMatch.group(2)
      tableName = patternMatch.group(3)
      creationQuery = ddlTableScript.replaceFirst(schemaName, databaseSchema).replaceFirst(tableName, sourceEntity_name)
    } yield creationQuery
    changedDdlTableScript.toList.mkString
  }
}
