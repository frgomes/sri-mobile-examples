enablePlugins(SriPlatformPlugin)

name := "UIExplorer"

scalaVersion := "2.11.11"

resolvers += Resolver.bintrayRepo("scalajs-react-interface", "maven")

libraryDependencies ++= Seq(
  "scalajs-react-interface" %%% "core" % "2017.7.9-RC",
  "scalajs-react-interface" %%% "mobile" % "2017.7.9-RC",
  "org.scala-lang.modules" %% "scala-async" % "0.9.6",
  "scalajs-react-interface" %%% "universal" % "2017.7.9-RC",
  "scalajs-react-interface" %%% "navigation" % "2017.7.9-RC",
  "scalajs-react-interface" %%% "platform-config-ios" % "2017.7.9-RC" % ios,
  "scalajs-react-interface" %%% "platform-config-android" % "2017.7.9-RC" % android
)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:existentials",
  "-language:implicitConversions"
)
