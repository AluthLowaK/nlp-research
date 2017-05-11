package org.gnuzero

import edu.stanford.nlp._
/**
  * Created by nayana on 10/5/2560.
  */
class StanfordCore {

  val s = new Sentence("gnu zero rocks!")

  def makeString:String = s.words.mkString("")

  def parseTree(sentence: String):String = {
    val s = new Sentence(sentence)
    s.parse.toString
  }

  def secondLevelOfTreeAsString(sentence: String):String = {
    val s = new Sentence(sentence)
    val tree = s.parse.children()

    //t.nodeString prints root
    //t.pennString() prints a tabbed out

    /*t.children().foreach(f => {
      println(f.nodeString())
    })*/

    val l = scala.collection.mutable.ListBuffer.empty[String]

    tree.foreach(f => {
        l.append(f.value())
        val nodes = f.children()
        nodes.foreach(leaf => {
            l.append(leaf.value())
        })

    })

    println(l)

    ""

  }
}
