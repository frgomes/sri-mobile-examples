package sri.mobile.examples.navigationx.stackintabs

import sri.navigation._

import scala.scalajs.js

trait ProfileParams extends js.Object {
  val name: js.UndefOr[String] = js.undefined
  val mode: js.UndefOr[String] = js.undefined
}

class ProfileScreen extends NavigationScreenComponent[ProfileParams, Null] {
  def render() =
    MyNavScreen(s"${if (params.get.mode.exists(_ == "edit")) "Now Editing"
    else ""} ${params.get.name.getOrElse("")}")
}
