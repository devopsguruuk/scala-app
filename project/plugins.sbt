logLevel := Level.Warn

addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.4.1")

resolvers += "maven-central2" at "http://central.maven.org/maven2/"

resolvers += "typesafe-releases" at "http://repo.typesafe.com/typesafe/releases"

resolvers += "typesafe-ivy-releasez" at "http://repo.typesafe.com/typesafe/ivy-releases"

resolvers += "sbt-releases-repo" at "http://repo.typesafe.com/typesafe/ivy-releases/"

resolvers += "maven-central" at "http://repo1.maven.org/maven2/"

resolvers += "maven-releases" at "https://repo.typesafe.com/typesafe/maven-releases/"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
