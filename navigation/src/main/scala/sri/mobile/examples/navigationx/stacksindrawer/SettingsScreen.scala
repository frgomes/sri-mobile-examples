package sri.mobile.examples.navigationx.stacksindrawer

import sri.navigation.{NavigationScreenComponentNoPS, NavigationScreenOptions}

import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}

@ScalaJSDefined
class SettingsScreen extends NavigationScreenComponentNoPS {

  def render() = MyNavScreen("Settings Screen")
}

object SettingsScreen {
  @JSExportStatic
  val navigationOptions = NavigationScreenOptions[SettingsScreen](
    title = "Settings"
  )
}
