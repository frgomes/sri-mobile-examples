package sri.mobile.examples.navigationx.stackintabs

import sri.navigation.{NavigationScreenComponentNoPS, NavigationScreenOptions}

import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}

@ScalaJSDefined
class HomeScreen extends NavigationScreenComponentNoPS {
  def render() = MyNavScreen("Home Screen")
}

object HomeScreen {
  @JSExportStatic
  val navigationOptions = NavigationScreenOptions[HomeScreen](
    title = "Home"
  )
}
