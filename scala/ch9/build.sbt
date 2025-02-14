// build.sbt
name := "ch9"

version := "0.1"

scalaVersion := "3.2.0"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % "0.14.1",
  "io.circe" %% "circe-generic" % "0.14.1",
  "io.circe" %% "circe-parser" % "0.14.1"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % Test