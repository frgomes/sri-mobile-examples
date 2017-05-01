package sri.mobile.examples.navigationx.drawerstacktab

import sri.navigation.{NavigationScreenComponentNoPS, NavigationScreenOptions}

import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}

@ScalaJSDefined
class HomeScreen extends NavigationScreenComponentNoPS {

  def render() = MyNavScreen("Home Screen")
}
