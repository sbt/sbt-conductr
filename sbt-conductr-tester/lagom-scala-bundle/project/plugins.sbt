addSbtPlugin("com.lightbend.lagom" % "lagom-sbt-plugin" % "1.3.1")

lazy val root = Project("plugins", file(".")).dependsOn(plugin)
lazy val plugin = file("../../").getCanonicalFile.toURI
