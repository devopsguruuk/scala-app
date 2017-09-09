name := "scala-template"

version := "1.0"

scalaVersion := "2.11.8"

//To run: sbt "run MoonGazer"
//If using arguments Quotes must!
mainClass in (Compile, run) := Some("com.isentia.daas.ScalaTemplate")

libraryDependencies += "org.apache.httpcomponents" % "httpcore" % "4.2"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.2"

libraryDependencies += "commons-io" % "commons-io" % "2.5"

libraryDependencies += "com.typesafe.play" % "play-json_2.11" % "2.4.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.5"

libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.5"

libraryDependencies += "org.clapper" %% "grizzled-slf4j" % "1.3.0"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.4.16"

//enablePlugins(DockerPlugin)

/*import sbtdocker.DockerKeys._

lazy val dockerSettings = Seq(
  // Make the docker task depend on the assembly task, which generates a fat JAR file
  docker <<= (docker dependsOn (AssemblyKeys.assembly in jobServerExtras)),
  dockerfile in docker := {
    val artifact = (AssemblyKeys.outputPath in AssemblyKeys.assembly in jobServerExtras).value
    val artifactTargetPath = s"/app/${artifact.name}"
    new sbtdocker.mutable.Dockerfile {
      from("ottoops/mesos-java7")
      copy(artifact, artifactTargetPath)
    }
  }
)*/
