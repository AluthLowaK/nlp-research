package org.gnuzero

import edu.stanford.nlp._
/**
  * Created by nayana on 10/5/2560.
  */
class StanfordCore {

  val s = new Sentence("gnu zero rocks!")

  def makeString:String = s.words.mkString("")

  def parseTree:String = {
    s.parse.toString
  }
}
