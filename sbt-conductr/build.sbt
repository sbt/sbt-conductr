import bintray.Keys._

name := "sbt-conductr"

libraryDependencies ++= List(
  Library.jansi,
  Library.jline,
  Library.jodaTime,
  Library.scalactic,
  Library.akkaTestkit % "test",
  Library.scalaTest   % "test"
)
addSbtPlugin(Library.sbtBundle)

resolvers ++= List(
  Resolver.typesafeReleases
)

sbtPlugin := true

licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))
publishMavenStyle := false
bintrayPublishSettings
repository in bintray := "sbt-plugins"
bintrayOrganization in bintray := Some("sbt-conductr")

scriptedSettings
scriptedLaunchOpts <+= version apply { v => s"-Dproject.version=$v" }
