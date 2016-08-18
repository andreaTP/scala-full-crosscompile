
lazy val root = project in file("."
) aggregate (demoJVM, demoJS, demoNATIVE)

lazy val commonSettings = Seq(
    name := "demo",
    organization := "eu.unicredit",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.11.8",
    sourcesInBase := false
  )

lazy val demo = crossProject in file("sources"
  ) settings ( commonSettings : _*
  ) jsSettings (
    //scalaJSUseRhino in Global := false
  )

lazy val demoJVM = demo.jvm
lazy val demoJS = demo.js

lazy val demoNATIVE = project in file("sources/native"
  ) settings (
    unmanagedSourceDirectories in Compile +=
      baseDirectory.value / ".." / "shared" / "src" / "main" / "scala"
  ) settings ( commonSettings : _*
  ) enablePlugins(ScalaNativePlugin)
