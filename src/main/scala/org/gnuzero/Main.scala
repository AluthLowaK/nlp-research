package org.gnuzero
/**
  * Created by nhettiarachc on 5/12/17.
  */

object Main extends App {

  val stanfordCore = new StanfordCore

  val json = new JsonReader

  import org.json4s.JsonDSL.WithDouble._
  import org.json4s.native.JsonMethods._

  println("running main")
  val idList = json.parseFile("/english.json")
  val parsedList:List[String] = idList.map(f => {
      stanfordCore.secondLevelOfTreeAsString(f)
  })

  compact(render(parsedList))

}
