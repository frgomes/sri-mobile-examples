package sri.mobile.examples.navigationx.drawerstacktab

import sri.navigation.{NavigationAwareComponentP, _}
import sri.universal.components._

class MyNavScreen extends NavigationAwareComponentP[String] {

  def render() = {
    ScrollViewC(
      sri.mobile.examples.navigationx.SampleText(props),
      Button(onPress = () => navigation.navigate[ProfileScreen],
             title = "Go to a profile screen"),
      Button(onPress = () => navigation.navigate[SettingsScreen],
             title = "Go to settings"),
      Button(onPress = () => navigation.navigate[NotificationsSettingsScreen],
             title = "Go to notification settings"),
      Button(onPress = () => navigationJS.goBack(null), title = "Go Back")
    )
  }

}

object Images {
  @inline def ios_home = "ios-home"
  @inline def ios_home2 = "ios-home"
  @inline def ios_home3 = "ios-home"
  @inline def ios_home4 = "ios-home"
}

object MyNavScreen {

  def apply(banner: String) = WithNavigation[MyNavScreen](banner)
}
