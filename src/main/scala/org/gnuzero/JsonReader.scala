package org.gnuzero

import java.io.InputStream
import org.json4s._
import org.json4s.native.JsonMethods._
/**
  * Created by nhettiarachc on 5/11/17.
  */
class JsonReader {

  def parseFile(fileName: String):List[String] = {
    val stream : InputStream = getClass.getResourceAsStream(fileName)
    val lines = scala.io.Source.fromInputStream( stream ).getLines().mkString("")

    val json = parse(lines)

    for {
      JObject(message) <- json
      JField("content", JString(content))  <- message
    } yield content

  }

}
