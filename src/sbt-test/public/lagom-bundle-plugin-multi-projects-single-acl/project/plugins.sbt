addSbtPlugin("com.lightbend.lagom" % "lagom-sbt-plugin" % "1.4.0")

addSbtPlugin("com.lightbend.conductr" % "sbt-conductr" % sys.props("project.version"))
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5"
