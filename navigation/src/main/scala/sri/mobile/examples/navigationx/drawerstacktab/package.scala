package sri.mobile.examples.navigationx

import sri.navigation._
import sri.navigation.navigators._
import sri.vector.icons.{Ionicons, IoniconsList}

package object drawerstacktab {

  val ProfileTab = TabNavigator(
    registerTabScreen[ProfileScreen](
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
        tabBarLabel = "Profile1"
      )),
    registerTabScreen[ProfileScreen2](
      navigationOptions = NavigationTabScreenOptions(
        tabBarIcon = (iconOptions: IconOptions) => {
          Ionicons(
            name =
              if (iconOptions.focused) IoniconsList.IOS_PEOPLE
              else IoniconsList.IOS_PEOPLE_OUTLINE,
            size = 27,
            style = GlobalStyles.dynamicColor(iconOptions.tintColor)
          )
        },
        tabBarLabel = "Profile2"
      ))
  )

  val MainDrawer = StackNavigator(
    registerStackScreen[HomeScreen](
      navigationOptions = NavigationStackScreenOptions(title = "Home")),
    registerNavigatorAsStackScreen("ProfileTab", ProfileTab))

  val SettingsDrawer = StackNavigator(
    registerStackScreen[SettingsScreen](
      navigationOptions = NavigationStackScreenOptions(title = "Settings")),
    registerStackScreen[NotificationsSettingsScreen](
      navigationOptions =
        NavigationStackScreenOptions(title = "Notification Settings"))
  )

  val root = DrawerNavigator(
    registerNavigatorAsDrawerScreen(
      "HomeDrawer",
      MainDrawer,
      navigationOptions = NavigationDrawerScreenOptions(
        drawerIcon = (iconOptions: IconOptions) => {
          Ionicons(
            name =
              if (iconOptions.focused) IoniconsList.IOS_HOME
              else IoniconsList.IOS_HOME_OUTLINE,
            size = 27,
            style = GlobalStyles.dynamicColor(iconOptions.tintColor)
          )
        },
        drawerLabel = "Home"
      )
    ),
    registerNavigatorAsDrawerScreen(
      "SettingsDrawer",
      SettingsDrawer,
      navigationOptions = NavigationDrawerScreenOptions(
        drawerIcon = (iconOptions: IconOptions) => {
          Ionicons(
            name =
              if (iconOptions.focused) IoniconsList.IOS_SETTINGS
              else IoniconsList.IOS_SETTINGS_OUTLINE,
            size = 27,
            style = GlobalStyles.dynamicColor(iconOptions.tintColor)
          )
        },
        drawerLabel = "Settings"
      )
    )
  )
}
