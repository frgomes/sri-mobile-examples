package sri.mobile.examples.navigationx.simplestack

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
             title = "Profile"),
      Button(onPress = () => navigation.goBack(null), title = "Go Back")
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
