package sri.mobile.examples.navigationx.drawerstacktab

import sri.navigation._

import scala.scalajs.js

trait ProfileParams extends js.Object {
  val name: js.UndefOr[String] = js.undefined
  val mode: js.UndefOr[String] = js.undefined
}

class ProfileScreen extends NavigationScreenComponentNoPS {
  def render() = MyNavScreen(s"Profile 1")
}
