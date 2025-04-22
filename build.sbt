ThisBuild / version := "0.1.0-SNAPSHOT"

val currentScalaVersion = "3.7.0-RC3"

ThisBuild / scalaVersion := currentScalaVersion

lazy val root = (project in file("."))
  .settings(
    crossScalaVersions := Seq("2.13.16", currentScalaVersion),
    scalaVersion := currentScalaVersion,
    libraryDependencies ++= {
      if (scalaVersion.value.startsWith("2.13")) {
        Seq("org.scala-lang" % "scala-reflect" % scalaVersion.value)
      } else {
        Seq.empty
      }
    },
    name := "generic-macro-tests"
  )
