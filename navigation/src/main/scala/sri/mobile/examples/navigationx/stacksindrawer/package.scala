package sri.mobile.examples.navigationx

import sri.navigation._
import sri.navigation.navigators._
import sri.universal.styles.UniversalStyleSheet
import sri.vector.icons.{Ionicons, IoniconsList}

package object stacksindrawer {

  val MainTab =
    StackNavigator(registerScreen[HomeScreen], registerScreen[ProfileScreen])

  val SettingsTab = StackNavigator(registerScreen[SettingsScreen],
                                   registerScreen[NotificationsSettingsScreen])

  val root = DrawerNavigator(
    registerNavigator(
      "HomeDrawer",
      MainTab,
      navigationOptions = NavigationScreenOptions[GenericScreen](
        drawer = DrawerConfig(
          icon = (iconOptions: IconOptions) => {
            Ionicons(
              name =
                if (iconOptions.focused) IoniconsList.IOS_HOME
                else IoniconsList.IOS_HOME_OUTLINE,
              size = 27,
              style = UniversalStyleSheet.style(color = iconOptions.tintColor,
                                                registerStyle = false)
            )
          },
          label = "Home"
        )
      )
    ),
    registerNavigator(
      "SettingsDrawer",
      SettingsTab,
      navigationOptions = NavigationScreenOptions[GenericScreen](
        drawer = DrawerConfig(
          icon = (iconOptions: IconOptions) => {
            Ionicons(
              name =
                if (iconOptions.focused) IoniconsList.IOS_SETTINGS
                else IoniconsList.IOS_SETTINGS_OUTLINE,
              size = 27,
              style = UniversalStyleSheet.style(color = iconOptions.tintColor,
                                                registerStyle = false)
            )
          },
          label = "Settings"
        )
      )
    )
  )
}
