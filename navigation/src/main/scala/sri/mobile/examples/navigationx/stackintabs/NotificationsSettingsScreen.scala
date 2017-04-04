package sri.mobile.examples.navigationx.stackintabs

import sri.navigation.{NavigationScreenComponentNoPS, NavigationScreenOptions}

import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}

@ScalaJSDefined
class NotificationsSettingsScreen extends NavigationScreenComponentNoPS {

  def render() = MyNavScreen("Notification Settings Screen")
}

object NotificationsSettingsScreen {

  @JSExportStatic
  val navigationOptions = NavigationScreenOptions[NotificationsSettingsScreen](
    title = "Notification Settings"
  )
}
