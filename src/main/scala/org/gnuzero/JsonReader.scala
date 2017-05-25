package org.gnuzero

import java.io.InputStream
import java.util
import java.util.Properties

import edu.stanford.nlp.Sentence
import edu.stanford.nlp.ling.CoreAnnotations.{PartOfSpeechAnnotation, SentencesAnnotation, TextAnnotation, TokensAnnotation}
import edu.stanford.nlp.ling.CoreLabel
import edu.stanford.nlp.pipeline.{Annotation, StanfordCoreNLP}
import edu.stanford.nlp.util.CoreMap
import org.json4s._
import org.json4s.native.JsonMethods._

import scala.collection.JavaConverters._
import scala.io.Source



/**
  * Created by nhettiarachc on 5/11/17.
  */
case class Message(conversation_id: Integer, property_id: Integer, property_name: String,
                    property_language_tag: Option[String], member_id: Integer, member_language_tag: String, created_when: String,
                    origin_type:Integer, sender_type: Integer, receive_type: Integer, content: String)

class JsonReader {

  implicit val formats = org.json4s.DefaultFormats



  def parseFile(fileName: String):List[String] = {
    val lines : Iterator[String] = Source.fromFile("src/main/resources/data.json").getLines()
    //val lines = scala.io.Source.fromInputStream( stream ).getLines.toString()

    val parsedSentences = lines.map(line => {
        //TokenizerExample.main(line).toString
      PosTaggerExample.main(line).toString
    })
    parsedSentences.toList
  }
}

object TokenizerExample {

  def main(sentence: String): Unit = {
    val props: Properties = new Properties()
    props.put("annotators", "tokenize, ssplit")

    val pipeline: StanfordCoreNLP = new StanfordCoreNLP(props)


    // create blank annotator
    val document: Annotation = new Annotation(sentence)

    // run all Annotator - Tokenizer on this text
    pipeline.annotate(document)

    val sentences: List[CoreMap] = document.get(classOf[SentencesAnnotation]).asScala.toList

    (for {
      sentence: CoreMap <- sentences
      token: CoreLabel <- sentence.get(classOf[TokensAnnotation]).asScala.toList
      word: String = token.get(classOf[TextAnnotation])

    } yield (word, token)) foreach(t => println("word: " + t._1 + " token: " +  t._2))
  }
}

object PosTaggerExample {

  def main(sentence: String): Unit = {
    val props: Properties = new Properties()
    props.put("annotators", "tokenize, ssplit, pos")

    val pipeline: StanfordCoreNLP = new StanfordCoreNLP(props)

    // read some text from a file - Uncomment this and comment the val text = "Quick...." below to load from a file
    //val inputFile: File = new File("src/test/resources/sample-content.txt")
    //val text: String = Files.toString(inputFile, Charset.forName("UTF-8"))
    val text = "Quick brown fox jumps over the lazy dog. This is Harshal."

    // create blank annotator
    val document: Annotation = new Annotation(text)

    // run all Annotator - Tokenizer on this text
    pipeline.annotate(document)

    val sentences: List[CoreMap] = document.get(classOf[SentencesAnnotation]).asScala.toList

    (for {
      sentence: CoreMap <- sentences
      token: CoreLabel <- sentence.get(classOf[TokensAnnotation]).asScala.toList
      word: String = token.get(classOf[TextAnnotation])
      pos: String = token.get(classOf[PartOfSpeechAnnotation])

    } yield (token, word, pos)) foreach(t => println("token: " + t._1 + " word: " +  t._2 + " pos: " +  t._3))


  }

}
