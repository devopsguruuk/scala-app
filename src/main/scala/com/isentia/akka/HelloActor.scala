package com.isentia.akka

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

/**
  * Created by ChetanP on 23/1/2017.
  */
class HelloActor(name:String) extends Actor {
  def receive = {
    case "hello" => println(s"hello $name back at you")
    case _       => println(s"$name huh?")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  // default Actor constructor
  val helloActor = system.actorOf(Props(new HelloActor("John")), name = "helloactor-2")
  helloActor ! "hello"
  helloActor ! "buenos dias"
}