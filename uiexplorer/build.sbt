enablePlugins(SriPlatFormPlugin)

name := "UIExplorer"

scalaVersion := "2.11.8"

resolvers += Resolver.bintrayRepo("scalajs-react-interface", "maven")
resolvers += Resolver.bintrayRepo("scalajs-react-interface", "maven")

libraryDependencies ++= Seq(
  "scalajs-react-interface" %%% "core" % "2017.3.26-beta",
  "scalajs-react-interface" %%% "mobile" % "2017.3.26-beta",
  "org.scala-lang.modules" %% "scala-async" % "0.9.6",
  "scalajs-react-interface" %%% "universal" % "2017.4.4-beta",
  "scalajs-react-interface" %%% "navigation" % "2017.3.26-beta",
  "scalajs-react-interface" %%% "platform-config-ios" % "2017.3.26-beta" % ios,
  "scalajs-react-interface" %%% "platform-config-android" % "2017.3.26-beta" % android
)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:existentials",
  "-language:implicitConversions"
)
