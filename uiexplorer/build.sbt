enablePlugins(SriPlatformPlugin)

name := "UIExplorer"

scalaVersion := "2.12.4"

resolvers += Resolver.bintrayRepo("scalajs-react-interface", "maven")
resolvers += Resolver.bintrayRepo("scalajs-plus", "maven")

libraryDependencies ++= Seq(
  "scalajs-react-interface" %%% "core" % "2017.12.28-RC",
  "scalajs-react-interface" %%% "mobile" % "2017.12.28-RC",
  "org.scala-lang.modules" %% "scala-async" % "0.9.6",
  "scalajs-react-interface" %%% "universal" % "2017.12.28-RC",
  "scalajs-react-interface" %%% "navigation" % "2017.12.28-RC",
  "scalajs-react-interface" %%% "platform-config-ios" % "2017.12.28-RC" % ios,
  "scalajs-react-interface" %%% "platform-config-android" % "2017.12.28-RC" % android
)

scalacOptions ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:existentials",
  "-language:implicitConversions"
)
