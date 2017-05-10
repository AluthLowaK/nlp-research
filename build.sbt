name := "nlp-research"

organization := "value-based-economy"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "edu.stanford.nlp" % "stanford-corenlp" % "3.4",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.4" classifier "models",
  "edu.stanford.nlp" % "stanford-parser" % "3.4"
)

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
