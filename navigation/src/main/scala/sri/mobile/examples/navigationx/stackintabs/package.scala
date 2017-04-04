package sri.mobile.examples.navigationx

import sri.navigation._
import sri.navigation.navigators._
import sri.universal.styles.UniversalStyleSheet
import sri.vector.icons.{Ionicons, IoniconsList}

package object stackintabs {

  val MainTab =
    StackNavigator(registerScreen[HomeScreen], registerScreen[ProfileScreen])

  val SettingsTab = StackNavigator(registerScreen[SettingsScreen],
                                   registerScreen[NotificationsSettingsScreen])

  val root = TabNavigator(
    TabNavigatorConfig(
      tabBarPosition = TabBarPosition.BOTTOM,
      animationEnabled = false,
      swipeEnabled = false
    ),
    registerNavigator(
      "MainTab",
      MainTab,
      navigationOptions = NavigationScreenOptions[GenericScreen](
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
          label = "Home"
        )
      )
    ),
    registerNavigator(
      "SettingsTab",
      SettingsTab,
      navigationOptions = NavigationScreenOptions[GenericScreen](
        tabBar = TabBarConfig(
          icon = (iconOptions: IconOptions) => {
            Ionicons(
              name =
                if (iconOptions.focused) IoniconsList.IOS_SETTINGS
                else IoniconsList.IOS_SETTINGS_OUTLINE,
              size = 27,
              style = UniversalStyleSheet.style(registerStyle = false,
                                                color = iconOptions.tintColor)
            )
          },
          label = "Settings"
        )
      )
    )
  )
}
