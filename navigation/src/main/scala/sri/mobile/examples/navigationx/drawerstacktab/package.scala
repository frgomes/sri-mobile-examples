package sri.mobile.examples.navigationx

import sri.navigation._
import sri.navigation.navigators._
import sri.universal.styles.UniversalStyleSheet
import sri.vector.icons.{Ionicons, IoniconsList}

package object drawerstacktab {

  val ProfileTab = TabNavigator(
    registerScreen[ProfileScreen],
    registerScreen[ProfileScreen2]
  )

  val MainDrawer = StackNavigator(registerScreen[HomeScreen],
                                  registerNavigator("ProfileTab", ProfileTab))

  val SettingsDrawer = StackNavigator(
    registerScreen[SettingsScreen],
    registerScreen[NotificationsSettingsScreen])

  val root = DrawerNavigator(
    registerNavigator(
      "HomeDrawer",
      MainDrawer,
      navigationOptions = NavigationScreenOptions[GenericScreen](
        drawer = DrawerConfig(
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
      "SettingsDrawer",
      SettingsDrawer,
      navigationOptions = NavigationScreenOptions[GenericScreen](
        drawer = DrawerConfig(
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
