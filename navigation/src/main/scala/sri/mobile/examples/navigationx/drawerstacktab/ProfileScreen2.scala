package sri.mobile.examples.navigationx.drawerstacktab

import sri.navigation._

import scala.scalajs.js

trait ProfileParams2 extends js.Object {
  val name: js.UndefOr[String] = js.undefined
  val mode: js.UndefOr[String] = js.undefined
}

class ProfileScreen2 extends NavigationScreenComponent[ProfileParams, Null] {
  def render() = MyNavScreen(s"Profile 2")
}
