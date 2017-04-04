package sri.mobile.examples.navigationx

import sri.navigation._
import sri.navigation.navigators._
package object drawer {

  val root = DrawerNavigator(
    DrawerNavigatorConfig(
      initialRouteName = getScreenName[DraftsScreen],
      contentOptions = DrawerContentOptions(
        activeTintColor = "#e91e63"
      )
    ),
    registerScreen[InboxScreen],
    registerScreen[DraftsScreen]
  )
}
