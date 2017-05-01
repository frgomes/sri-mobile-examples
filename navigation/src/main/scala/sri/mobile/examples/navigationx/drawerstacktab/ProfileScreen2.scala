package sri.mobile.examples.navigationx.drawerstacktab

import sri.navigation._
import sri.universal.styles.UniversalStyleSheet
import sri.vector.icons.{Ionicons, IoniconsList}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}

@ScalaJSDefined
trait ProfileParams2 extends js.Object {
  val name: js.UndefOr[String] = js.undefined
  val mode: js.UndefOr[String] = js.undefined
}

@ScalaJSDefined
class ProfileScreen2 extends NavigationScreenComponent[ProfileParams, Null] {
  def render() = MyNavScreen(s"Profile 2")
}
