package sri.mobile.examples.uiexplorer

import sri.mobile.examples.uiexplorer.components.{
  UIExplorerDetailsScreen,
  UIExplorerListScreen
}
import sri.navigation._
import sri.navigation.navigators._
import sri.universal.apis.AppRegistry

import scala.scalajs.js.JSApp

object MobileApp extends JSApp {

  def main() = {
    sri.core.setReactElementType
    val root = StackNavigator(
      registerStackScreen[UIExplorerListScreen](navigationOptions =
        NavigationStackScreenOptions(title = "UIExplorer")),
      registerStackScreen[UIExplorerDetailsScreen](
        navigationOptionsDynamic =
          (props: NavigationScreenConfigProps[UIExplorerDetailsScreen]) =>
            NavigationStackScreenOptions(
              title = props.navigation.state.params.get.title))
    )
    AppRegistry.registerComponent("UIExplorer", () => root)
  }
}
