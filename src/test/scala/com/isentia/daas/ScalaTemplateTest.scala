package com.isentia.daas

import collection.mutable.Stack
import org.scalatest._

class ScalaTemplateTest extends IsentiaSpec {

  "Call to printString method" should "return a Non-Zero Length String" in {
    ScalaTemplate.printString("John") should be("Hello World John")
  }
}
