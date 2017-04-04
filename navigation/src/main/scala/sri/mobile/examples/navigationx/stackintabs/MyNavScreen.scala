package sri.mobile.examples.navigationx.stackintabs

import sri.core.CreateElement
import sri.navigation.{NavigationAwareComponentP, _}
import sri.universal.components._

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}

@ScalaJSDefined
class MyNavScreen extends NavigationAwareComponentP[String] {

  def render() = {
    ScrollView(
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
      Button(onPress = () => navigation.goBack(null), title = "Go Back")
    )
  }

}

object MyNavScreen {

  @JSExportStatic
  val contextTypes =
    navigationContextType

  def apply(banner: String) = CreateElement[MyNavScreen](banner)
}
