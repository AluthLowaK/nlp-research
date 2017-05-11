package org.gnuzero

import org.scalatest._

/**
  * Created by nayana on 10/5/2560.
  */
class StanfordCoreSuite extends FunSuite {
  val stanfordCore = new StanfordCore

  val json = new JsonReader

  /*test("Tree parser ") {
    println(stanfordCore.secondLevelOfTreeAsString("Do this hotel have car parking lot?"))
    assert(true)
  }

  test("as full string") {
    println(stanfordCore.parseTree("Do this hotel have car parking lot?"))
    assert(true)
  }*/

  test("full tree test") {
    val idList = json.parseFile("/data.json")
    val parsedList = idList.map(f => {
        stanfordCore.parseTree(f)
    })
    println(parsedList.mkString("\n"))
    assert(parsedList.size === 2)
  }

  test("second level test") {
    val idList = json.parseFile("/data.json")
    val parsedList = idList.map(f => {
      stanfordCore.secondLevelOfTreeAsString(f)
    })

    println(parsedList)
    assert(parsedList.size === 2)

  }
}
