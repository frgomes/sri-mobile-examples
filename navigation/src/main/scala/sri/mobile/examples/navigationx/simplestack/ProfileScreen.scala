package sri.mobile.examples.navigationx.simplestack

import sri.navigation.NavigationScreenOptionsImplicits._
import sri.navigation._
import sri.universal.components._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}

@ScalaJSDefined
trait ProfileParams extends js.Object {
  val name: js.UndefOr[String] = js.undefined
  val mode: js.UndefOr[String] = js.undefined
}

@ScalaJSDefined
class ProfileScreen extends NavigationScreenComponentP[ProfileParams] {
  def render() =
    MyNavScreen(s"${if (params.get.mode.exists(_ == "edit")) "Now Editing"
    else ""} ${params.get.name.getOrElse("")}")
}
