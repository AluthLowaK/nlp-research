name := "nlp-research"

organization := "value-based-economy"

version := "1.0"

scalaVersion := "2.11.9"

libraryDependencies ++= Seq(
  "edu.stanford.nlp" % "stanford-corenlp" % "3.4",
  "edu.stanford.nlp" % "stanford-corenlp" % "3.4" classifier "models",
  "edu.stanford.nlp" % "stanford-parser" % "3.4",
  "org.json4s" %% "json4s-native" % "3.5.2"
)

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test"
