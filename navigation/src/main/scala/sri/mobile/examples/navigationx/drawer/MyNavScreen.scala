package sri.mobile.examples.navigationx.drawer

import sri.mobile.examples.navigationx.GlobalStyles
import sri.navigation.{NavigationAwareComponentP, _}
import sri.universal.components._

class MyNavScreen extends NavigationAwareComponentP[String] {

  def render() = {
    ScrollView(style = GlobalStyles.navScreenContainer)(
      sri.mobile.examples.navigationx.SampleText(props),
      Button(onPress = () => navigation.openDrawer, title = "Open Drawer"),
      Button(onPress = () => navigationJS.goBack(null), title = "Go Back")
    )
  }

}

object MyNavScreen {

  def apply(banner: String) = WithNavigation[MyNavScreen](banner)
}
