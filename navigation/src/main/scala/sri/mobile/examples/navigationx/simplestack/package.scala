package sri.mobile.examples.navigationx

import sri.navigation._
import sri.navigation.navigators._
import sri.universal.components.Button

import scala.scalajs.js
package object simplestack {

  val root = StackNavigator(
    registerStackScreen[HomeScreen](
      navigationOptions = NavigationStackScreenOptions(title = "Home")),
    registerStackScreen[PhotosScreen](
      navigationOptions = NavigationStackScreenOptions(title = "Photos")),
    registerStackScreen[ProfileScreen](
      navigationOptionsDynamic =
        (props: NavigationScreenConfigProps[ProfileScreen]) =>
          NavigationStackScreenOptions(
            title =
              props.navigation.state.params.get.name.getOrElse("").toString,
            headerRight = Button(
              title =
                if (props.navigation.state.params.get.mode.exists(_ == "edit"))
                  "Done"
                else "Edit",
              onPress = () =>
                props.navigation.setParams(new ProfileParams {
                  override val mode: js.UndefOr[String] =
                    if (props.navigation.state.params.get.mode
                          .exists(_ == "edit")) ""
                    else "edit"
                })
            )
        ))
  )
}
