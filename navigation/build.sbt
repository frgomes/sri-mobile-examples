enablePlugins(SriPlatformPlugin)

name := "mobile-examples-navigation"
organization := "scalajs-react-interface"

val scala212 = "2.12.8"
val scala213 = "2.13.0"

scalaVersion := scala212
crossScalaVersions := Seq(scala212, scala213)

resolvers += Resolver.bintrayRepo("scalajs-react-interface", "maven")
resolvers += Resolver.bintrayRepo("scalajs-plus", "maven")

libraryDependencies ++= Seq(
  "scalajs-react-interface" %%% "core" % "2019.06.26",
  "scalajs-react-interface" %%% "vector-icons" % "2019.06.26",
  "scalajs-react-interface" %%% "mobile" % "2019.06.26",
  "scalajs-react-interface" %%% "universal" % "2019.06.26",
  "scalajs-react-interface" %%% "platform-config-ios" % "2019.06.26" % IOS,
  "scalajs-react-interface" %%% "platform-config-android" % "2019.06.26" % Android,
  "scalajs-react-interface" %%% "navigation" % "2019.06.26",
)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions"
)
