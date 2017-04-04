package sri.mobile.examples.navigationx.drawerstacktab

import sri.core.CreateElement
import sri.navigation.{NavigationAwareComponentP, _}
import sri.universal.components._

import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}
@ScalaJSDefined
class MyNavScreen extends NavigationAwareComponentP[String] {

  def render() = {
    ScrollView(
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

  @JSExportStatic
  val contextTypes =
    navigationContextType

  def apply(banner: String) = CreateElement[MyNavScreen](banner)
}
