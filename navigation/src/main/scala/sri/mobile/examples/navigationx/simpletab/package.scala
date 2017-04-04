package sri.mobile.examples.navigationx

import sri.navigation._
import sri.platform._
import sri.navigation.navigators._
package object simpletab {

  val root = TabNavigator(
    TabNavigatorConfig(
      tabBarOptions = TabBarOptions(
        activeTintColor = if (SriPlatForm.isIOS) "#e91e63" else "#fff")
    ),
    registerScreen[HomeScreen],
    registerScreen[SettingsScreen],
    registerScreen[ChatScreen],
    registerScreen[PeopleScreen]
  )
}
