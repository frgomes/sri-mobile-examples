package sri.mobile.examples.navigationx

import sri.navigation._
import sri.navigation.navigators._
import sri.universal.components.Button
import sri.vector.icons.{Ionicons, IoniconsList}

import scala.scalajs.js

package object stackintabs {

  val MainTab =
    StackNavigator(
      registerStackScreen[HomeScreen](
        navigationOptions = NavigationStackScreenOptions(title = "Home")),
      registerStackScreen[ProfileScreen](
        navigationOptionsDynamic =
          (props: NavigationScreenConfigProps[ProfileScreen]) =>
            NavigationStackScreenOptions(
              title =
                props.navigation.state.params.get.name.getOrElse("").toString,
              headerRight = Button(
                title =
                  if (props.navigation.state.params.get.mode
                        .exists(_ == "edit"))
                    "Done"
                  else "Edit",
                onPress = () =>
                  props.navigation.setParams(new ProfileParams {
                    override val mode: js.UndefOr[String] =
                      if (props.navigation.state.params.get.mode
                            .exists(_ == "edit"))
                        ""
                      else "edit"
                  })
              )
          ))
    )

  val SettingsTab = StackNavigator(
    registerStackScreen[SettingsScreen](
      navigationOptions = NavigationStackScreenOptions(title = "Settings")),
    registerStackScreen[NotificationsSettingsScreen](
      navigationOptions =
        NavigationStackScreenOptions(title = "Notification Settings"))
  )

  val root = TabNavigator(
    TabNavigatorConfig(
      tabBarPosition = TabBarPosition.BOTTOM,
      animationEnabled = false,
      swipeEnabled = false
    ),
    registerNavigatorAsTabScreen(
      "MainTab",
      MainTab,
      navigationOptions = NavigationTabScreenOptions(
        tabBarIcon = (iconOptions: IconOptions) => {
          Ionicons(
            name =
              if (iconOptions.focused) IoniconsList.IOS_HOME
              else IoniconsList.IOS_HOME_OUTLINE,
            size = 27,
            style = GlobalStyles.dynamicColor(iconOptions.tintColor)
          )
        },
        tabBarLabel = "Home"
      )
    ),
    registerNavigatorAsTabScreen(
      "SettingsTab",
      SettingsTab,
      navigationOptions = NavigationTabScreenOptions(
        tabBarIcon = (iconOptions: IconOptions) => {
          Ionicons(
            name =
              if (iconOptions.focused) IoniconsList.IOS_SETTINGS
              else IoniconsList.IOS_SETTINGS_OUTLINE,
            size = 27,
            style = GlobalStyles.dynamicColor(iconOptions.tintColor)
          )
        },
        tabBarLabel = "Settings"
      )
    )
  )
}
