package sri.mobile.examples.navigationx.stacksindrawer

import sri.navigation.{NavigationAwareComponentP, _}
import sri.universal.components._

import scala.scalajs.js

class MyNavScreen extends NavigationAwareComponentP[String] {

  def render() = {
    ScrollViewC(
      sri.mobile.examples.navigationx.SampleText(props),
      Button(onPress = () =>
               navigation.navigate[ProfileScreen](new ProfileParams {
                 override val name: js.UndefOr[String] = "Jane"
               }),
             title = "Go to a profile screen"),
      Button(onPress = () => navigation.navigate[SettingsScreen],
             title = "Go to settings"),
      Button(onPress = () => navigation.navigate[NotificationsSettingsScreen],
             title = "Go to notification settings"),
      Button(onPress = () => navigationJS.goBack(null), title = "Go Back")
    )
  }

}

object MyNavScreen {

  def apply(banner: String) = WithNavigation[MyNavScreen](banner)
}
