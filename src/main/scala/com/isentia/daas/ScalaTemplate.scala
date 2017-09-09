package com.isentia.daas

import grizzled.slf4j.Logger

/**
  * Created by ChetanP on 12/1/2017.
  * A Test Class.
  */
object ScalaTemplate {
  val log = Logger[this.type]

  def main(args: Array[String]): Unit = {
    var name = ""
    if (args != null && args.length > 0) {
      name = args(0)
    }
    log.info(printString(name))
  }

  def printString(arg:String = ""):String = {
    return s"Hello World $arg"
  }
}
