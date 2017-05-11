package org.gnuzero

import java.io.InputStream
/**
  * Created by nhettiarachc on 5/11/17.
  */
class JsonReader {

  def parseFile(fileName: String):String = {
    val stream : InputStream = getClass.getResourceAsStream(fileName)
    val lines = scala.io.Source.fromInputStream( stream ).getLines.toString()

    //val parsedData = parse(lines)


    /*parsedData.children.foreach(v => {
        println(v)
    })*/

    lines

  }

}
