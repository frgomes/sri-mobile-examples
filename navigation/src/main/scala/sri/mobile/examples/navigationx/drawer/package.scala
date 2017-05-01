package sri.mobile.examples.navigationx

import sri.navigation._
import sri.navigation.navigators._
import sri.vector.icons.{MaterialIcons, MaterialIconsList}
package object drawer {

  val root = DrawerNavigator(
    DrawerNavigatorConfig(
      initialRouteName = getScreenName[DraftsScreen],
      contentOptions = DrawerContentOptions(
        activeTintColor = "#e91e63"
      )
    ),
    registerDrawerScreen[InboxScreen](
      navigationOptions = NavigationDrawerScreenOptions(
        drawerLabel = "Inbox",
        drawerIcon = (options: IconOptions) => {
          MaterialIcons(name = MaterialIconsList.INBOX,
                        size = 24,
                        color = options.tintColor)
        })),
    registerDrawerScreen[DraftsScreen](
      navigationOptions = NavigationDrawerScreenOptions(
        drawerLabel = "Drafts",
        drawerIcon = (options: IconOptions) => {
          MaterialIcons(name = MaterialIconsList.DRAFTS,
                        size = 24,
                        color = options.tintColor)
        }))
  )
}
