package sri.mobile.examples.navigationx.drawerstacktab

import sri.navigation._
import sri.universal.styles.UniversalStyleSheet
import sri.vector.icons.{Ionicons, IoniconsList}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportStatic, ScalaJSDefined}

@ScalaJSDefined
trait ProfileParams extends js.Object {
  val name: js.UndefOr[String] = js.undefined
  val mode: js.UndefOr[String] = js.undefined
}

@ScalaJSDefined
class ProfileScreen extends NavigationScreenComponentNoPS {
  def render() = MyNavScreen(s"Profile 1")
}

object ProfileScreen {

  @JSExportStatic
  val navigationOptions = NavigationScreenOptions[ProfileScreen](
    title = "Profile",
//      header = ((navigation: NavigationScreenProp[ProfileParams]) => {
//         HeaderConfig(
//           title = navigation.state.params.get.name.getOrElse("").toString
//           right = Button(title = if(navigation.state.params.mode.exists(_ == "edit")) "Done" else "Edit",
//             onPress = () => navigation.setParams(new ProfileParams {
//               override val mode: js.UndefOr[String] = if(navigation.state.params.mode.exists(_ == "edit")) "" else "edit"
//             }))
//         }
//      })
    tabBar = TabBarConfig(
      icon = (iconOptions: IconOptions) => {
        Ionicons(
          name =
            if (iconOptions.focused) IoniconsList.IOS_HOME
            else IoniconsList.IOS_HOME_OUTLINE,
          size = 27,
          style = UniversalStyleSheet.style(registerStyle = false,
                                            color = iconOptions.tintColor)
        )
      },
      label = "Profile1"
    )
  )
}
