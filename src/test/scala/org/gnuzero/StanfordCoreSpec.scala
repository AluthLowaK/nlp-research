package org.gnuzero

import org.scalatest.FunSuite
/**
  * Created by nayana on 10/5/2560.
  */
class StanfordCoreSuite extends FunSuite {
  test("Tree parser ") {
    val stanfordCore = new StanfordCore
    assert(stanfordCore.parseTree.equals("xxxxx"))
  }
}
