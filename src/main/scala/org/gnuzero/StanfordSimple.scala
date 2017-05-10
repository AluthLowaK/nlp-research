package org.gnuzero

import edu.stanford.nlp.simple._
/**
  * Created by nayana on 10/5/2560.
  */
class StanfordSimple {

  val s = new Sentence("a new world era!")

  def wordSeperate():String = s.words.mkString(" :: ")

}
