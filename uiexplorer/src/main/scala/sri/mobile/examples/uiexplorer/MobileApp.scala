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
    val root = StackNavigator(registerScreen[UIExplorerListScreen],
                              registerScreen[UIExplorerDetailsScreen])
    AppRegistry.registerComponent("UIExplorer", () => root)
  }
}
